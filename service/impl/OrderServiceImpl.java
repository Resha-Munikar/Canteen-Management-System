package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int orderId) {
        Optional<Order> optionalUser = orderRepository.findById(orderId);
        Order order= optionalUser.orElseThrow(()->new RuntimeException("Order not found"));
        return order;
    }

    @Override
    public List<Order> findByUserId(int userId) {
        return List.of();
    }

    @Override
    public Order updateOrder(Order order, int orderId) {
        getById(orderId);//check id
        order.setOrderId(orderId);
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int orderId) {
        getById(orderId);
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> findByStatus(String orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);

    }

    @Override
    public double calculateTotalAmount(int orderId) {
        Order order = getById(orderId); // Reuse the `getById` method to fetch the order.
        return order.getTotalAmount();
    }
}
