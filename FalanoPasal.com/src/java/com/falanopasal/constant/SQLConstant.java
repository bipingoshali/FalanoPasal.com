/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.constant;

/**
 *
 * @author bipin
 */
public class SQLConstant {
    
    public class User {

        public final static String USER_INSERT = "INSERT INTO "
                + TableConstant.USER_TABLE
                + " (firstName,lastName,email,username,password,city,"
                + "addressline1,addressline2,houseno,phoneno,birthdate,roleid,status,emailToken,enrollDate)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        public final static String IS_USERNAME_EXIST = "SELECT COUNT(username) FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";
        
        public final static String GET_BY_USERNAME = "SELECT * FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";
                
        public final static String GET_BY_USERID = "SELECT * FROM "
                +TableConstant.USER_TABLE+
                " where userId=?";
        
        public final static String UPDATE_USER_STATUS = "UPDATE " + TableConstant.USER_TABLE
                + " set status=true where userId=?";

    }

    public class cookie {

        public final static String INSERT_COOKIE = "INSERT INTO " + TableConstant.COOKIE_TABLE
                + " VALUES(?,?)";
        
        public final static String GET_BY_COOKIE_VALUE = "SELECT * FROM user u,remembercookies r where u.username=r.username and token=?";
        
        public final static String DELETE_COOKIE = "DELETE FROM " + TableConstant.COOKIE_TABLE +
                " WHERE username=?";
                                
    }
                
    public class Category{
        
        public final static String GET_CATEGORY = "SELECT * FROM " + TableConstant.CATEGORY_TABLE;
        
        public final static String INSERT_CATEGORY = "INSERT INTO " + TableConstant.CATEGORY_TABLE +
                " (categoryName) values(?)";

        public final static String GET_ALL_CATEGORY_BY_ID = "SELECT * FROM " + TableConstant.CATEGORY_TABLE
                + " where categoryId=?";
        
    }
    
    public class Product{
        
        public final static String GET_PRODUCT = "SELECT * FROM " + TableConstant.PRODUCT_TABLE;
        
        public final static String GET_CATEGORY_BY_ID = "SELECT categoryName from " + TableConstant.CATEGORY_TABLE
                + " where categoryId=?";
        
        public final static String GET_PRODUCT_BY_CATEGORYID = "Select * from "
                +TableConstant.PRODUCT_TABLE+
                " where categoryId=?";

        public final static String INSERT_PRODUCT = "INSERT INTO " + TableConstant.PRODUCT_TABLE 
                + " (categoryId,productName,price,calorieValue,description,stockAmount)"
                + " values(?,?,?,?,?,?)";
        
        public final static String GET_PRODUCT_BY_ID = "SELECT * FROM " + TableConstant.PRODUCT_TABLE +
                " WHERE productId=?";
        
        public final static String EDIT_PRODUCT = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET productName=?,price=?,calorieValue=?,description=? where productId=?";
        
        public final static String UPDATE_PRODUCT_STOCK = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET stockAmount=stockAmount+? where productId=?";

        public final static String UPDATE_PRODUCT_CATEGORY_TYPE = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET categoryId=? where productId=?";

        public final static String DELETE_PRODUCT = "DELETE FROM " + TableConstant.PRODUCT_TABLE +
                " WHERE productId=?";
        
        
    }
    
    public class ShoppingCarts{
        
        public final static String REGISTER_USER_SHOPPING_CART = "INSERT INTO " + TableConstant.SHOPPING_CARTS_TABLE +
                " (cartId,username,purchased,purchasedDate) values (?,?,false,?)";
        
        public final static String REGISTER_USER_SHOPPING_CART_ITEM = "INSERT INTO " + TableConstant.SHOPPING_CART_ITEM_TABLE +
                " (cartId,productId,productQuantity,productPrice,productTotalPrice,productTotalCalorie) values(?,?,?,?,?,?)";
               
    }
    
    public class OrderHistory{
        
        public final static String GET_USER_ORDER_HISTORY = "SELECT * FROM shoppingcarts sc,shoppingcartitem sci where sc.cartId=sci.cartId and sc.username=?";
    }
    
}
