package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table (name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    @Column(unique = true,nullable = false)
    private String pName;
    @Column(nullable = false)
    private Double pPrice;
    private Double pDiscount;
    @Column(nullable = false)
    private int pQuantity;
    @Column(nullable = false)
    private String pStatus;

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    @Column(nullable = false)
    private String pCategory;

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Double getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(Double pDiscount) {
        this.pDiscount = pDiscount;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

}
