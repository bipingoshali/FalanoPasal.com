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
public class Package {
    private int productId,newPrice;

    public Package() {
    }
    
    

    public Package(int productId, int newPrice) {
        this.productId = productId;
        this.newPrice = newPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }
    
    
    
}
