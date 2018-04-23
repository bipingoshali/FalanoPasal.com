/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import java.util.Date;

/**
 *
 * @author bipin
 */
public class Offer {
    private int offerId,orderCount,productId;
    private String productName;
    private String type;
    private double priceTag;
    private String username;
    private Date offerBoughtDate;

    public Offer(int offerId, int orderCount, int productId, String productName, String type, double priceTag, String username, Date offerBoughtDate) {
        this.offerId = offerId;
        this.orderCount = orderCount;
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.priceTag = priceTag;
        this.username = username;
        this.offerBoughtDate = offerBoughtDate;
    }

    public Date getOfferBoughtDate() {
        return offerBoughtDate;
    }

    public void setOfferBoughtDate(Date offerBoughtDate) {
        this.offerBoughtDate = offerBoughtDate;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Offer() {
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(double priceTag) {
        this.priceTag = priceTag;
    }
    
    
}
