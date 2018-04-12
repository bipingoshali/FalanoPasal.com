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
public class Offer {
    private int offerId,orderCount,productId;
    private String type;
    private double priceTag;

    public Offer(int offerId, int orderCount, int productId, String type, double priceTag) {
        this.offerId = offerId;
        this.orderCount = orderCount;
        this.productId = productId;
        this.type = type;
        this.priceTag = priceTag;
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
