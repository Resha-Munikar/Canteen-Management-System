package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;


public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAll();
    Product getProductById(int pId);
    void deleteProductById(int pId);
    Product updateProduct(Product product, int pId);
    Product findByPName(String pName);
}
