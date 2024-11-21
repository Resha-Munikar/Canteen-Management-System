package com.example.demo.service.impl;
import com.example.demo.model.Sales;
import com.example.demo.repository.SalesRepository;
import com.example.demo.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public Sales addSale(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public void deleteSaleById(int saleId) {
        salesRepository.deleteById(saleId);
    }

    @Override
    public Sales updateSale(Sales sales, int saleId) {
        if (salesRepository.existsById(saleId)) {
            sales.setSaleId(saleId); // Ensure the saleId remains the same
            return salesRepository.save(sales);
        }
        return null;
    }

    @Override
    public List<Sales> findAll() {
        return salesRepository.findAll();
    }

    @Override
    public List<Sales> findAllByProductId(int productId) {
        List<Sales> salesList = salesRepository.findByProduct_PId(productId);
        if (salesList.isEmpty()) {
            throw new RuntimeException("No sales found for the given product ID");
        }
        return salesList;
    }
}
