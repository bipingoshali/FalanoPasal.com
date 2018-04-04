/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.ShoppingCartHandlerEntry;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface ShoppingCartItemCalculateStrategyService {
    double getTotal(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries); 
    double getTotalCalorieValue(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries);    
}
