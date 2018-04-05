/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.ShoppingCartHandlerEntry;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface OrderService {
    void registerUserShoppingCart(String cartId,int userId) throws SQLException,ClassNotFoundException;
    void registerUserShoppingCartItem(String cartId,List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException,ClassNotFoundException;
    List<ShoppingCartHandlerEntry> order(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries);
}
