/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author bipin
 */
@Component
public class ShoppingCartMap {
    int itemCount; //to count number of products in a cart
    Map<Integer,Integer> cartItems; //to store productId and quantity
        
    public ShoppingCartMap(){
        itemCount=0;
        cartItems = new HashMap<>();
    }
    
    public void addItem(int productId,int quantity){
        if(!cartItems.containsKey(productId)){
            cartItems.put(productId, quantity); //product id and its quantity is register in here
        }else{
            cartItems.put(productId, cartItems.get(productId)+quantity); //works when quantity is added agian in the same product Id
        }
        itemCount+=quantity;            
    }
    
    public Map<Integer, Integer> getCartItems(){
        return cartItems;
    }
    
    public int getQuantity(int productId){
        return cartItems.get(productId);
    }
    
    public int getItemSize(){
        return itemCount;
    }
    
    public void clearHashmap(){
        itemCount=0;
        cartItems.clear();
    }
    

    
}
