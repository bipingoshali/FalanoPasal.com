/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.dao.ShoppingCartItemCalculateStrategyDAO;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class ShoppingCartItemCalculateStrategyDAOImpl implements ShoppingCartItemCalculateStrategyDAO {

    @Override
    public double getTotal(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        double total = 0.0;

        for (ShoppingCartHandlerEntry s : shoppingCartHandlerEntries) {
            total += s.getProductTotalPrice();
        }
        return total;
    }

    @Override
    public double getTotalCalorieValue(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        double total = 0.0;

        for (ShoppingCartHandlerEntry s : shoppingCartHandlerEntries) {
            total += s.getTotalCalorieValue();
        }
        return total;
    }

}
