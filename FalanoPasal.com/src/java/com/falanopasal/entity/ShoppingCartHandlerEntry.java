/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

/**
 *
 * @author bipin
 */
public class ShoppingCartHandlerEntry {
    private int productId,quantity;
    private String productName;
    private double price,productTotalPrice,calorieValue,totalCalorieValue;
    private Product product;

    public ShoppingCartHandlerEntry() {
    }

    public ShoppingCartHandlerEntry(int productId, int quantity, String productName, double price, double productTotalPrice, double calorieValue, double totalCalorieValue, Product product) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
        this.productTotalPrice = productTotalPrice;
        this.calorieValue = calorieValue;
        this.totalCalorieValue = totalCalorieValue;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public double getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(double calorieValue) {
        this.calorieValue = calorieValue;
    }

    public double getTotalCalorieValue() {
        return totalCalorieValue;
    }

    public void setTotalCalorieValue(double totalCalorieValue) {
        this.totalCalorieValue = totalCalorieValue;
    }
    
    
    
}
