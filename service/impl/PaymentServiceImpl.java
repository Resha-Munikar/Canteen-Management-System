package com.example.demo.service.impl;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentByOrderId(int orderId) {
        List<Payment> payments = paymentRepository.findByOrder_orderId(orderId); // Find list of payments by orderId
        return payments.stream()
                .findFirst() // Get the first payment if exists
                .orElseThrow(() -> new RuntimeException("Payment not found for Order ID: " + orderId)); // Throw exception if no payment found
    }

    @Override
    public boolean deletePaymentByOrderId(int orderId) {
        // Fetch the payment to ensure it exists
        Payment payment = getPaymentByOrderId(orderId);
        paymentRepository.delete(payment);
        return true;
    }
}
