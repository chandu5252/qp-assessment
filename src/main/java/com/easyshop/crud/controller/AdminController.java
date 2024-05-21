package com.easyshop.crud.controller;

import com.easyshop.crud.entity.GroceryItem;
import com.easyshop.crud.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping("/grocery-items")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return groceryItemService.addGroceryItem(item);
    }

    @GetMapping("/grocery-items")
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @DeleteMapping("/grocery-items/{id}")
    public void deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
    }

    @PutMapping("/grocery-items/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return groceryItemService.updateGroceryItem(id, item);
    }

    @PutMapping("/grocery-items/{id}/inventory")
    public GroceryItem updateInventory(@PathVariable Long id, @RequestParam int quantity) {
        return groceryItemService.updateInventory(id, quantity);
    }
}
