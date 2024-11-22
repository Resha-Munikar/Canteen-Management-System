package com.example.demo.service;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {
    // Add a new order to the system
    Order add(Order order);

    // Retrieve a list of all orders
    List<Order> getAll();

    // Find an order by its unique identifier
    Order getById(int orderId);

    // Find all orders placed by a specific user (e.g., by username or userId)
    List<Order> findByUserId(int id);

    // Update the details of an existing order
    Order updateOrder(Order order, int orderId);

    // Cancel or delete an order by its ID
    void deleteById(int orderId);

    // Retrieve all orders with a specific status (e.g., "Pending", "Completed")
    List<Order> findByStatus(String orderStatus);

    // Calculate the total amount for an order
    double calculateTotalAmount(int orderId);
}
