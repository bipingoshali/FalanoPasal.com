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
public class ShoppingCart {
    private String cartId;
    private String username;
    private boolean purchased;
    private Date purchasedDate;
    private String paymentMethod;
    private double grandTotal;
    private ShoppingCartHandlerEntry shoppingCartHandlerEntry;

    public ShoppingCart() {
    }

    public ShoppingCart(String cartId, String username, boolean purchased, Date purchasedDate, String paymentMethod, double grandTotal, ShoppingCartHandlerEntry shoppingCartHandlerEntry) {
        this.cartId = cartId;
        this.username = username;
        this.purchased = purchased;
        this.purchasedDate = purchasedDate;
        this.paymentMethod = paymentMethod;
        this.grandTotal = grandTotal;
        this.shoppingCartHandlerEntry = shoppingCartHandlerEntry;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }


    public ShoppingCartHandlerEntry getShoppingCartHandlerEntry() {
        return shoppingCartHandlerEntry;
    }

    public void setShoppingCartHandlerEntry(ShoppingCartHandlerEntry shoppingCartHandlerEntry) {
        this.shoppingCartHandlerEntry = shoppingCartHandlerEntry;
    }

    

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }



    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
    
    
}
