/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author bipin
 */
public class Product {
    private int categoryId,productId,stockValue,updatedStockValue;
    private String productName,description;
    private float productPrice,calorieValue;
    private Category category;
    
    private MultipartFile productImage;

    public Product() {
    }

    public Product(int categoryId, int productId, int stockValue, int updatedStockValue, String productName, String description, float productPrice, float calorieValue, Category category, MultipartFile productImage) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.stockValue = stockValue;
        this.updatedStockValue = updatedStockValue;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.calorieValue = calorieValue;
        this.category = category;
        this.productImage = productImage;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }


    public int getUpdatedStockValue() {
        return updatedStockValue;
    }

    public void setUpdatedStockValue(int updatedStockValue) {
        this.updatedStockValue = updatedStockValue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stockValue) {
        this.stockValue = stockValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(float calorieValue) {
        this.calorieValue = calorieValue;
    }
    
    
    
}
