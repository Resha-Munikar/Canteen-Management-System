package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping("/list")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    // Add a new order
    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.add(order);
    }

    // Update an existing order
    @PutMapping("/update/{orderId}")
    public Order updateOrder(@RequestBody Order order, @PathVariable int orderId) {
        return orderService.updateOrder(order, orderId);
    }

    // Get a specific order by ID
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable int orderId) {
        return orderService.getById(orderId);
    }

    // Delete an order by ID
    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable int orderId) {
        orderService.deleteById(orderId);
    }

    // Get all orders by status
    @GetMapping("/status/{orderStatus}")
    public List<Order> getOrdersByStatus(@PathVariable String orderStatus) {
        return orderService.findByStatus(orderStatus);
    }

    // Get all orders placed by a specific user
    @GetMapping("/user/{id}")
    public List<Order> getOrdersByUserId(@PathVariable int id) {
        return orderService.findByUserId(id);
    }

    // Calculate the total amount for a specific order
    @GetMapping("/calculate/{orderId}")
    public double calculateTotalAmount(@PathVariable int orderId) {
        return orderService.calculateTotalAmount(orderId);
    }
}
