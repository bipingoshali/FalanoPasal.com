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
public class ShoppingCart {
    private String cartId;
    private int userId;
    private boolean purchased;
    private ShoppingCartHandlerEntry shoppingCartHandlerEntry;

    public ShoppingCart() {
    }

    public ShoppingCart(String cartId, int userId, boolean purchased, ShoppingCartHandlerEntry shoppingCartHandlerEntry) {
        this.cartId = cartId;
        this.userId = userId;
        this.purchased = purchased;
        this.shoppingCartHandlerEntry = shoppingCartHandlerEntry;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
    
    
}
