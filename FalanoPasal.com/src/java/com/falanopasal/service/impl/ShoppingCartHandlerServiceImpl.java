/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.ShoppingCartHandlerDAO;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.ShoppingCartMap;
import com.falanopasal.service.ShoppingCartHandlerService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class ShoppingCartHandlerServiceImpl implements ShoppingCartHandlerService{

    @Autowired
    private ShoppingCartHandlerDAO shoppingCartHandlerDao;
    
    @Override
    public List<ShoppingCartHandlerEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) throws SQLException, ClassNotFoundException {
        return shoppingCartHandlerDao.getShoppingCartEntries(shoppingCartMap);
    }

    @Override
    public double getTotalPrice(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        return shoppingCartHandlerDao.getTotalPrice(shoppingCartHandlerEntries);
    }

    @Override
    public double getTotalCalorie(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        return shoppingCartHandlerDao.getTotalCalorie(shoppingCartHandlerEntries);
    }
    
}
