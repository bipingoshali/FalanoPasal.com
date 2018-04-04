/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.ShoppingCartMap;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface ShoppingCartHandlerDAO {
    List<ShoppingCartHandlerEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) throws SQLException,ClassNotFoundException;
    double getTotalPrice(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries);
    double getTotalCalorie(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries);
}
