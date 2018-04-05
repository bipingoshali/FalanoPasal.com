/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.controller.SessionManager;
import com.falanopasal.dao.OrderDAO;
import com.falanopasal.entity.ShoppingCart;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
        
    @Override
    public List<ShoppingCartHandlerEntry> order(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) {
        jdbcTemplate.update(SQLConstant.ShoppingCarts.REGISTER_USER_SHOPPING_CART, new Object[]{2});
        return null;
    }

    @Override
    public void registerUserShoppingCart(String cartId,int userId) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.ShoppingCarts.REGISTER_USER_SHOPPING_CART, new Object[]{cartId,userId});
    }

    @Override
    public void registerUserShoppingCartItem(ShoppingCart shoppingCart,List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException, ClassNotFoundException {
        for(int i=0;i<shoppingCartHandlerEntries.size();i++){
            shoppingCartHandlerEntries.get(i).getProductId();
            jdbcTemplate.update(SQLConstant.ShoppingCarts.REGISTER_USER_SHOPPING_CART_ITEM,
                    new Object[]{shoppingCart.getCartId(),
                                 shoppingCartHandlerEntries.get(i).getProductId(),
                                 shoppingCartHandlerEntries.get(i).getQuantity(),
                                 shoppingCartHandlerEntries.get(i).getPrice(),
                                 shoppingCartHandlerEntries.get(i).getProductTotalPrice(),
                                 shoppingCartHandlerEntries.get(i).getTotalCalorieValue()});            
        }
    }

    @Override
    public List<ShoppingCartHandlerEntry> getUserShoppingCarts() throws SQLException,ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.OrderHistory.GET_USER_ORDER_HISTORY, new RowMapper<ShoppingCartHandlerEntry>() {
            @Override
            public ShoppingCartHandlerEntry mapRow(ResultSet rs, int i) throws SQLException {
                return mapShoppingCartHandlerEntryData(rs);
            }
        });
    }
    
    private ShoppingCartHandlerEntry mapShoppingCartHandlerEntryData(ResultSet rs) throws SQLException{
        ShoppingCartHandlerEntry s = new ShoppingCartHandlerEntry();
        s.setProductId(rs.getInt("productId"));
        s.setQuantity(rs.getInt("productQuantity"));
        s.setProductTotalPrice(rs.getDouble("productTotalPrice"));
        s.setTotalCalorieValue(rs.getInt("productTotalCalorie"));
        return s;
    }

        
}
