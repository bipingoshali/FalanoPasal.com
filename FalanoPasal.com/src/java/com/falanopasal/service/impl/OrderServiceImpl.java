/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.OrderDAO;
import com.falanopasal.entity.ShoppingCart;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.service.OrderService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class OrderServiceImpl implements OrderService{

    @Autowired 
    private OrderDAO orderDao;
    
    @Override
    public void registerUserShoppingCart(ShoppingCart shoppingCart) throws SQLException, ClassNotFoundException {
        orderDao.registerUserShoppingCart(shoppingCart);
    }

    @Override
    public void registerUserShoppingCartItem(ShoppingCart shoppingCart, List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException, ClassNotFoundException {
        orderDao.registerUserShoppingCartItem(shoppingCart, shoppingCartHandlerEntries);
    }

    @Override
    public List<ShoppingCartHandlerEntry> getUserShoppingCarts(String username) throws SQLException, ClassNotFoundException {
        return orderDao.getUserShoppingCarts(username);
    }
    
}
