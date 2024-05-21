package com.easyshop.crud.controller;

import com.easyshop.crud.entity.Order;
import com.easyshop.crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> getOrders(){
        return service.getOrders();
    }

}
