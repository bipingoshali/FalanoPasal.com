/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author bipin
 */
public class Product {
    private int categoryId,productId,stockValue,updatedStockValue;
    private String productName,description;
    private float productPrice,calorieValue;
    private int productRating;
    private String productComment;
    private String productSubscriptionDuration;
    private Date productCommentDate,productSubscribeDate;
    private int subscribeProductQuantity;
    private String username; //to find which user is rating a product
    private Category category;
    
    private MultipartFile productImage;

    public Product() {
    }

    public Product(int categoryId, int productId, int stockValue, int updatedStockValue, String productName, String description, float productPrice, float calorieValue, int productRating, String productComment, String productSubscriptionDuration, Date productCommentDate, Date productSubscribeDate, int subscribeProductQuantity, String username, Category category, MultipartFile productImage) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.stockValue = stockValue;
        this.updatedStockValue = updatedStockValue;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.calorieValue = calorieValue;
        this.productRating = productRating;
        this.productComment = productComment;
        this.productSubscriptionDuration = productSubscriptionDuration;
        this.productCommentDate = productCommentDate;
        this.productSubscribeDate = productSubscribeDate;
        this.subscribeProductQuantity = subscribeProductQuantity;
        this.username = username;
        this.category = category;
        this.productImage = productImage;
    }

    public int getSubscribeProductQuantity() {
        return subscribeProductQuantity;
    }

    public void setSubscribeProductQuantity(int subscribeProductQuantity) {
        this.subscribeProductQuantity = subscribeProductQuantity;
    }


    public String getProductSubscriptionDuration() {
        return productSubscriptionDuration;
    }

    public void setProductSubscriptionDuration(String productSubscriptionDuration) {
        this.productSubscriptionDuration = productSubscriptionDuration;
    }


    public Date getProductSubscribeDate() {
        return productSubscribeDate;
    }

    public void setProductSubscribeDate(Date productSubscribeDate) {
        this.productSubscribeDate = productSubscribeDate;
    }



    public Date getProductCommentDate() {
        return productCommentDate;
    }

    public void setProductCommentDate(Date productCommentDate) {
        this.productCommentDate = productCommentDate;
    }


    

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
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
