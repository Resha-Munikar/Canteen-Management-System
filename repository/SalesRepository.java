package com.example.demo.repository;

import com.example.demo.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
    List<Sales> findByProduct_PId(int productId);

}
