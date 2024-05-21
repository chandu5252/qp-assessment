package com.easyshop.crud.service;

import com.easyshop.crud.entity.GroceryItem;
import com.easyshop.crud.entity.Order;
import com.easyshop.crud.entity.OrderItem;
import com.easyshop.crud.exception.InsufficientStockException;
import com.easyshop.crud.exception.ResourceNotFoundException;
import com.easyshop.crud.repository.GroceryItemRepository;
import com.easyshop.crud.repository.OrderItemRepository;
import com.easyshop.crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public Order createOrder(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            GroceryItem item = groceryItemRepository.findById(orderItem.getGroceryItem().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
            if (item.getQuantity() < orderItem.getQuantity()) {
                throw new InsufficientStockException("Not enough stock for item: " + item.getName());
            }
            item.setQuantity(item.getQuantity() - orderItem.getQuantity());
            groceryItemRepository.save(item);
        }
        return orderRepository.save(order);
    }

    public Order getOrdersByUser(Long userId) {
        return orderRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+userId));
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
}
