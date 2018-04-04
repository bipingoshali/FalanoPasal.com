/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.ShoppingCartItemCalculateStrategyDAO;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.service.ShoppingCartItemCalculateStrategyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class ShoppingCartItemCalculateStrategyServiceImpl implements ShoppingCartItemCalculateStrategyService{

    @Autowired
    private ShoppingCartItemCalculateStrategyDAO shoppingCartItemCalculateStrategyDao;
    
    @Override
    public double getTotal(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        return shoppingCartItemCalculateStrategyDao.getTotal(shoppingCartHandlerEntries);
    }

    @Override
    public double getTotalCalorieValue(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        return shoppingCartItemCalculateStrategyDao.getTotalCalorieValue(shoppingCartHandlerEntries);        
    }
    
}
