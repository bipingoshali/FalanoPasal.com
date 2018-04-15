/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.OrderDAO;
import com.falanopasal.entity.ShoppingCart;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void registerUserShoppingCart(ShoppingCart shoppingCart) throws SQLException, ClassNotFoundException {        
        jdbcTemplate.update(SQLConstant.ShoppingCarts.REGISTER_USER_SHOPPING_CART,
                new Object[]{shoppingCart.getCartId(),
                    shoppingCart.getUsername(),
                    shoppingCart.getPaymentMethod(),
                    shoppingCart.getGrandTotal(),
                    shoppingCart.getTotalCalorieValue(),
                    shoppingCart.getPurchasedDate()});
    }

    @Override
    public void registerUserShoppingCartItem(ShoppingCart shoppingCart,List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException, ClassNotFoundException {
        for(int i=0;i<shoppingCartHandlerEntries.size();i++){
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
    public void minusProductStock(List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries) throws SQLException, ClassNotFoundException {
        for(int i=0;i<shoppingCartHandlerEntries.size();i++){
            jdbcTemplate.update(SQLConstant.Product.MINUS_PRODUCT_STOCK,
                    new Object[]{shoppingCartHandlerEntries.get(i).getQuantity(),
                                shoppingCartHandlerEntries.get(i).getProductId()});
        }
    }
    

    @Override
    public List<ShoppingCart> getUserShoppingCarts(String username) throws SQLException,ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.OrderHistory.GET_USER_ORDER_HISTORY, new String[]{username}, new RowMapper<ShoppingCart>() {
            @Override
            public ShoppingCart mapRow(ResultSet rs, int i) throws SQLException {
                return mapShoppingCartData(rs);
            }
        });
    }
    

    @Override
    public List<ShoppingCart> getAllShoppingCart() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.ShoppingCarts.GET_ALL_CART, new RowMapper<ShoppingCart>() {
            @Override
            public ShoppingCart mapRow(ResultSet rs, int i) throws SQLException {
                return mapShoppingCartData(rs);
            }
        });
    }

    private ShoppingCart mapShoppingCartData(ResultSet rs) throws SQLException{
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartId(rs.getString("cartId"));
        shoppingCart.setUsername(rs.getString("username"));
        shoppingCart.setPurchased(rs.getBoolean("purchased"));
        shoppingCart.setPaymentMethod(rs.getString("paymentMethod"));
        shoppingCart.setGrandTotal(rs.getDouble("grandtotal"));
        shoppingCart.setTotalCalorieValue(rs.getDouble("totalCalorie"));
        shoppingCart.setPurchasedDate(rs.getDate("purchasedDate"));
        return shoppingCart;
    }

    @Override
    public List<ShoppingCartHandlerEntry> getAllShoppingCartItemByCartId(String cartId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.ShoppingCarts.GET_ALL_CART_ITEM_BY_CARTID, new String[]{cartId}, new RowMapper<ShoppingCartHandlerEntry>() {
            @Override
            public ShoppingCartHandlerEntry mapRow(ResultSet rs, int i) throws SQLException {
                return mapShoppingCartItemData(rs);
            }
        });
    }
    
    private ShoppingCartHandlerEntry mapShoppingCartItemData(ResultSet rs) throws SQLException{
        ShoppingCartHandlerEntry s = new ShoppingCartHandlerEntry();
        s.setProductName(this.getProductName(rs.getInt("productId")));
        s.setProductId(rs.getInt("productId"));
        s.setQuantity(rs.getInt("productQuantity"));
        s.setPrice(rs.getDouble("productPrice"));
        s.setProductTotalPrice(rs.getDouble("productTotalPrice"));
        s.setTotalCalorieValue(rs.getDouble("productTotalCalorie"));
        return s;
    }
    
    public String getProductName(int productId){
        String productName="";
        productName = jdbcTemplate.queryForObject(SQLConstant.Product.GET_PRODUCT_NAME_BY_ID, new Object[]{productId}, String.class);
        return productName;
    }    

    @Override
    public void updateOrderStatus(User user) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.ShoppingCarts.UPDATE_ORDER_STATUS, new Object[]{user.getCartId(),user.getUsername()});
    }



        
}
