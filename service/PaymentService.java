package com.example.demo.service;

import com.example.demo.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);
    List<Payment> getAll();
    Payment getPaymentByOrderId(int orderId);
    boolean deletePaymentByOrderId(int orderId);
}
