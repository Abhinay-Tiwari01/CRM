package com.abhi.CRM.Model.EntryEntites;

import jakarta.persistence.*;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Product_Code")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;

    @Column(name = "Product_Name")
    private String productName;
    private String unit;
    private String category;
    private String brand;

    @Column(name = "STax")
    private String salesTax;

    @Column(name = "PTax")
    private String purchaseTax;

    @Column(name = "MRP")
    private String mrp;
    private String subCategory;
    private String description;
    private Long discount;
    private String productProperty;
    private String hsnCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getPurchaseTax() {
        return purchaseTax;
    }

    public void setPurchaseTax(String purchaseTax) {
        this.purchaseTax = purchaseTax;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(String productProperty) {
        this.productProperty = productProperty;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public ProductEntity(int id, int code, String productName, String unit, String category, String brand, String salesTax, String purchaseTax, String mrp, String subCategory, String description, Long discount, String productProperty, String hsnCode) {
        this.id = id;
        this.code = code;
        this.productName = productName;
        this.unit = unit;
        this.category = category;
        this.brand = brand;
        this.salesTax = salesTax;
        this.purchaseTax = purchaseTax;
        this.mrp = mrp;
        this.subCategory = subCategory;
        this.description = description;
        this.discount = discount;
        this.productProperty = productProperty;
        this.hsnCode = hsnCode;
    }

    public ProductEntity() {
    }
}
