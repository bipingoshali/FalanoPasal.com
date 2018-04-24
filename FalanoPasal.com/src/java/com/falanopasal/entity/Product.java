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
    private String manufacturerName,location,manufacturedDate,expiryDateStringFormat;
    private Date manufactureDateFormat,expiryDateFormat;
    private int expiryDate; //providing the number of month and system automatically assigns the date    
    private int productRating,productSubscribedId;
    private String productComment;
    private String productSubscriptionDuration;
    private Date productCommentDate,productSubscribeDate,productRateDate;
    private int subscribeProductQuantity;
    private String username; //to find which user is rating a product
    private Category category;
    private boolean subscribedProductStatus;
    private int boughtCount;
    
    private MultipartFile productImage;

    public Product() {
    }

    public Product(int categoryId, int productId, int stockValue, int updatedStockValue, String productName, String description, float productPrice, float calorieValue, String manufacturerName, String location, String manufacturedDate, String expiryDateStringFormat, Date manufactureDateFormat, Date expiryDateFormat, int expiryDate, int productRating, int productSubscribedId, String productComment, String productSubscriptionDuration, Date productCommentDate, Date productSubscribeDate, Date productRateDate, int subscribeProductQuantity, String username, Category category, boolean subscribedProductStatus, int boughtCount, MultipartFile productImage) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.stockValue = stockValue;
        this.updatedStockValue = updatedStockValue;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.calorieValue = calorieValue;
        this.manufacturerName = manufacturerName;
        this.location = location;
        this.manufacturedDate = manufacturedDate;
        this.expiryDateStringFormat = expiryDateStringFormat;
        this.manufactureDateFormat = manufactureDateFormat;
        this.expiryDateFormat = expiryDateFormat;
        this.expiryDate = expiryDate;
        this.productRating = productRating;
        this.productSubscribedId = productSubscribedId;
        this.productComment = productComment;
        this.productSubscriptionDuration = productSubscriptionDuration;
        this.productCommentDate = productCommentDate;
        this.productSubscribeDate = productSubscribeDate;
        this.productRateDate = productRateDate;
        this.subscribeProductQuantity = subscribeProductQuantity;
        this.username = username;
        this.category = category;
        this.subscribedProductStatus = subscribedProductStatus;
        this.boughtCount = boughtCount;
        this.productImage = productImage;
    }

    public int getBoughtCount() {
        return boughtCount;
    }

    public void setBoughtCount(int boughtCount) {
        this.boughtCount = boughtCount;
    }

    public Product(String productName, int boughtCount) {
        this.productName = productName;
        this.boughtCount = boughtCount;
    }



    public boolean isSubscribedProductStatus() {
        return subscribedProductStatus;
    }

    public void setSubscribedProductStatus(boolean subscribedProductStatus) {
        this.subscribedProductStatus = subscribedProductStatus;
    }


    public int getProductSubscribedId() {
        return productSubscribedId;
    }

    public void setProductSubscribedId(int productSubscribedId) {
        this.productSubscribedId = productSubscribedId;
    }


    public Date getProductRateDate() {
        return productRateDate;
    }

    public void setProductRateDate(Date productRateDate) {
        this.productRateDate = productRateDate;
    }


    public String getExpiryDateStringFormat() {
        return expiryDateStringFormat;
    }

    public void setExpiryDateStringFormat(String expiryDateStringFormat) {
        this.expiryDateStringFormat = expiryDateStringFormat;
    }


    public Date getExpiryDateFormat() {
        return expiryDateFormat;
    }

    public void setExpiryDateFormat(Date expiryDateFormat) {
        this.expiryDateFormat = expiryDateFormat;
    }

    
    public Date getManufactureDateFormat() {
        return manufactureDateFormat;
    }

    public void setManufactureDateFormat(Date manufactureDateFormat) {
        this.manufactureDateFormat = manufactureDateFormat;
    }


    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
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
