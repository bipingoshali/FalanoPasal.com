/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.ShoppingCart;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface OrderDAO {
    //register user shopping cart
    void registerUserShoppingCart(ShoppingCart shoppingCart) throws SQLException,ClassNotFoundException;
    
    //add products in user shopping cart
    void registerUserShoppingCartItem(ShoppingCart shoppingCart,List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException,ClassNotFoundException;
        
    //get order history
    List<ShoppingCartHandlerEntry> getUserShoppingCarts(String username) throws SQLException,ClassNotFoundException;
    
    //get all shopping cart list
    List<ShoppingCart> getAllShoppingCart() throws SQLException,ClassNotFoundException;
    
    //get all shopping cart item by cart id
    List<ShoppingCartHandlerEntry> getAllShoppingCartItemByCartId(String cartId) throws SQLException,ClassNotFoundException;
    
    //minus product stock after order
    void minusProductStock(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException,ClassNotFoundException;
    
    //update order status
    void updateOrderStatus(User user) throws SQLException,ClassNotFoundException; 
    
}
