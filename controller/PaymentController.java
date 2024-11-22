package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @GetMapping("/list")
    public List<Payment> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/{orderId}")
    public Payment getPaymentById(@PathVariable int orderId){
        return paymentService.getPaymentByOrderId(orderId);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deletePaymentByOrderId(@PathVariable int orderId) {
        boolean isDeleted = paymentService.deletePaymentByOrderId(orderId);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content if deletion is successful
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if payment not found
        }
    }
}
