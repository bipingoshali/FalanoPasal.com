/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.dao.ShoppingCartHandlerDAO;
import com.falanopasal.entity.Product;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.ShoppingCartMap;
import com.falanopasal.service.ProductService;
import com.falanopasal.service.ShoppingCartItemCalculateStrategyService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class ShoppingCartHandlerDAOImpl implements ShoppingCartHandlerDAO{

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ShoppingCartItemCalculateStrategyService shoppingCartItemCalculateStrategyService;
    
    @Override
    public List<ShoppingCartHandlerEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) throws SQLException,ClassNotFoundException {
        List<ShoppingCartHandlerEntry> shoppingCartsHandlerEntries = new ArrayList<>();
        
        for(int productId:shoppingCartMap.getCartItems().keySet()){
            Product product = productService.getProductByProductId(productId);
            ShoppingCartHandlerEntry s = new ShoppingCartHandlerEntry();
            
            int quantity = shoppingCartMap.getQuantity(productId);
            
            s.setProductName(product.getProductName());
            s.setPrice(product.getProductPrice());
            s.setCalorieValue(product.getCalorieValue());
            s.setProductTotalPrice(product.getProductPrice() * quantity);
            s.setTotalCalorieValue(product.getCalorieValue() * quantity);            
            s.setQuantity(quantity);
            
            shoppingCartsHandlerEntries.add(s);
        }
        return shoppingCartsHandlerEntries;
    }

    @Override
    public double getTotalPrice(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        return shoppingCartItemCalculateStrategyService.getTotal(shoppingCartHandlerEntries);
    }

    @Override
    public double getTotalCalorie(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        return shoppingCartItemCalculateStrategyService.getTotal(shoppingCartHandlerEntries);
    }
    
}
