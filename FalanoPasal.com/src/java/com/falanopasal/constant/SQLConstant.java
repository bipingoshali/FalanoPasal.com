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
                + "addressline1,addressline2,houseno,familytype,phoneno,birthdate,roleid,status,emailToken,debitamount,ordercount,enrollDate)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0,?)";
        
        public final static String IS_USERNAME_EXIST = "SELECT COUNT(username) FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";
        
        public final static String CHECK_USER_CREDIT = "SELECT COUNT(username) FROM "
                + TableConstant.SHOPPING_CARTS_TABLE +
                " WHERE username=? and paymentMethod='Credit'";
        
        public final static String GET_BY_USERNAME = "SELECT * FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";
                
        public final static String GET_BY_USERID = "SELECT * FROM "
                +TableConstant.USER_TABLE+
                " where userId=?";
        
        public final static String UPDATE_USER_STATUS = "UPDATE " + TableConstant.USER_TABLE
                + " set status=true where userId=?";
        
        public final static String GET_ALL_CUSTOMER = "SELECT * FROM " + TableConstant.USER_TABLE;
        
        public final static String MINUS_DEBIT_AMOUNT = "UPDATE " + TableConstant.USER_TABLE +
                " SET debitamount=debitamount-? WHERE username=?";
        
        public final static String UPDATE_ORDER_COUNT = "UPDATE " + TableConstant.USER_TABLE +
                " SET ordercount=ordercount+1 where username=?";
        
        public final static String UPDATE_PASSWORD = "UPDATE " + TableConstant.USER_TABLE + 
                " SET password=? where username=?";
        
        public final static String GET_TOTAL_EXPENSES="SELECT SUM(grandtotal) from SHOPPINGCARTS where username=?";
        
        public final static String GET_USER_CREDIT_AMOUNT = "select sum(grandtotal) from shoppingcarts where username=? and paymentMethod='Credit'";
        

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
        
        public final static String GET_CATEGORY_NAME_BY_ID = "SELECT categoryName from " + TableConstant.CATEGORY_TABLE
                + " where categoryId=?";

    }
    
    public class Product{
        
        public final static String GET_PRODUCT = "SELECT * FROM " + TableConstant.PRODUCT_TABLE;

        public final static String GET_PRODUCT_NAME_BY_ID = "SELECT productName FROM " + TableConstant.PRODUCT_TABLE + 
                " where productId=?";
        
        public final static String GET_PRODUCT_BY_CATEGORYID = "Select * from "
                +TableConstant.PRODUCT_TABLE+
                " where categoryId=?";

        public final static String INSERT_PRODUCT = "INSERT INTO " + TableConstant.PRODUCT_TABLE 
                + " (categoryId,productName,price,calorieValue,description,stockAmount,manufacturername,location,manufacturedate,expirydate,productbought)"
                + " values(?,?,?,?,?,?,?,?,?,DATE_ADD(manufacturedate, INTERVAL ? MONTH),0)";
        
        public final static String GET_PRODUCT_BY_ID = "SELECT * FROM " + TableConstant.PRODUCT_TABLE +
                " WHERE productId=?";
        
        public final static String EDIT_PRODUCT = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET productName=?,price=?,calorieValue=?,description=?,manufacturername=?,"
                + "location=?,manufacturedate=?,expirydate=? where productId=?";
        
        public final static String UPDATE_PRODUCT_STOCK = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET stockAmount=stockAmount+? where productId=?";
        
        public final static String UPDATE_PRODUCT_BOUGHT = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET productbought=productbought+? where productId=?";

        public final static String UPDATE_PRODUCT_CATEGORY_TYPE = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET categoryId=? where productId=?";

        public final static String DELETE_PRODUCT = "DELETE FROM " + TableConstant.PRODUCT_TABLE +
                " WHERE productId=?";
        
        public final static String MINUS_PRODUCT_STOCK = "UPDATE " + TableConstant.PRODUCT_TABLE +
                " SET stockAmount=stockAmount-? where productId=?";
        
        public final static String GET_PRODUCT_BY_PRICE = "SELECT * FROM " + TableConstant.PRODUCT_TABLE +
                " ORDER BY price DESC";

        public final static String GET_PRODUCT_BY_POPULARITY = "select p.productId,p.categoryId,p.productName,p.price,p.calorieValue,p.description,p.stockAmount,p.manufacturername,p.location,p.manufacturedate,p.expirydate "
                + "from rating r,product p where p.productId=r.productId order by rating desc";
        
        
    }
    
    public class ShoppingCarts{
        
        public final static String REGISTER_USER_SHOPPING_CART = "INSERT INTO " + TableConstant.SHOPPING_CARTS_TABLE +
                " (cartId,username,purchased,paymentMethod,grandtotal,totalCalorie,purchasedDate) values (?,?,false,?,?,?,?)";
        
        public final static String REGISTER_USER_SHOPPING_CART_ITEM = "INSERT INTO " + TableConstant.SHOPPING_CART_ITEM_TABLE +
                " (cartId,productId,productQuantity,productPrice,productTotalPrice,productTotalCalorie) values(?,?,?,?,?,?)";
        
        public final static String GET_ALL_CART = "SELECT * FROM " + TableConstant.SHOPPING_CARTS_TABLE +
                " order by shoppingcarts.purchasedDate DESC";
        
        public final static String GET_ALL_CART_ITEM_BY_CARTID = "SELECT * FROM " + TableConstant.SHOPPING_CART_ITEM_TABLE +
                " WHERE cartId=?";
        
        public final static String UPDATE_ORDER_STATUS = "UPDATE " + TableConstant.SHOPPING_CARTS_TABLE +
                " SET purchased=true where cartId=? and username=?";
        
        public final static String GET_TOTAL_CALORIE_VALUE = "SELECT SUM(totalCalorie) from " + TableConstant.SHOPPING_CARTS_TABLE +
                " where username=?";
        
        public final static String CHECK_USERNAME_IN_SHOPPING_CART = "SELECT COUNT(username) FROM " + TableConstant.SHOPPING_CARTS_TABLE+
                " WHERE username=?";
        
        public final static String CHECK_PRODUCT_BOUGHT_RATE_BY_CUSTOMER = "SELECT productId, COUNT(*) AS Mode FROM shoppingcartitem GROUP BY productId ORDER BY COUNT(*) DESC";
        
        public final static String CHECK_CUSTOMER_BOUGHT_RATE = "SELECT username, COUNT(*) AS Mode FROM shoppingcarts GROUP BY username ORDER BY COUNT(*) DESC";
        
                               
    }
    
    public class OrderHistory{
        
        public final static String GET_USER_ORDER_HISTORY = "SELECT * FROM " + TableConstant.SHOPPING_CARTS_TABLE+
                " where username=? order by purchasedDate desc" ;
    }
    
    public class ProductRatingCommenting{
        public final static String RATE_PRODUCT = "INSERT INTO " + TableConstant.PRODUCT_RATING_TABLE +
                " (username,productId,rating,ratingdate) VALUES(?,?,?,?)";
        
        public final static String COMMENT_PRODUCT = "INSERT INTO " + TableConstant.PRODUCT_COMMENTING_TABLE +
                " (username,productId,comment,commenteddate) VALUES(?,?,?,?)";
        
        public final static String GET_ALL_COMMENT_BY_PRODUCTID = "SELECT * FROM " + TableConstant.PRODUCT_COMMENTING_TABLE
                + " WHERE productId=? order by commenteddate DESC";
        
        public final static String GET_COMMENT_BY_USERNAME = "SELECT * FROM " + TableConstant.PRODUCT_COMMENTING_TABLE +
                " WHERE username=?";
        
        public final static String CHECK_USER_RATING = "SELECT COUNT(rating) FROM " + TableConstant.PRODUCT_RATING_TABLE +
                " WHERE username=? and productId=?";
        
        public final static String UPDATE_USER_RATING = "UPDATE " + TableConstant.PRODUCT_RATING_TABLE +
                " SET rating=?,ratingdate=? where username=? and productId=?";
        
        public final static String GET_USER_RATING = "SELECT rating from " + TableConstant.PRODUCT_RATING_TABLE +
                " where username=? and productId=?";
        
        public final static String GET_PRODUCT_RATING = "SELECT AVG(rating) from " + TableConstant.PRODUCT_RATING_TABLE;
    }
    
    public class SubscribeProduct{
        
        public final static String SUBSCRIBE_PRODUCT = "INSERT INTO " + TableConstant.SUBSCRIBE_PRODUCT_TABLE +
                " (username,productId,quantity,duration,status,date) values(?,?,?,?,true,?)";
        
        public final static String GET_ALL_SUBSCRIBE_PRODUCT_BY_USERNAME = "SELECT * FROM " + TableConstant.SUBSCRIBE_PRODUCT_TABLE +
                " WHERE username=?";
        
        public final static String GET_ALL_SUBSCRIBE_PRODUCT = "SELECT * FROM " + TableConstant.SUBSCRIBE_PRODUCT_TABLE;
        
        public final static String PAUSE_SUBSCRIPTION = "UPDATE " + TableConstant.SUBSCRIBE_PRODUCT_TABLE +
                " SET status=false where username=? and productId=?";
        
        public final static String START_SUBSCRIPTION = "UPDATE " + TableConstant.SUBSCRIBE_PRODUCT_TABLE + 
                " SET status=true where username=? and productId=?";
        
        public final static String CANCEL_SUBSCRIPTION = "DELETE FROM " + TableConstant.SUBSCRIBE_PRODUCT_TABLE +
                " WHERE username=? and productId=?";
        
    }
    
    public class Delivery{
        public final static String DELIVERY_INSERT = "INSERT INTO " + TableConstant.DELIVERY_TABLE +
                " (cartid,deliverytype,customdate,customtime) values(?,?,?,?)";
    }
    
    public class Offer{
        
        public final static String OFFER_INSERT = "INSERT INTO " + TableConstant.OFFER_TABLE + 
                " (type,ordercount,productid,pricetag) VALUES(?,?,?,?)";
        
        public final static String GET_ALL_OFFER_BY_ORDERCOUNT = "SELECT * FROM " + TableConstant.OFFER_TABLE +
                " WHERE ordercount<=?";;
        
        public final static String GET_ALL_OFFER = "SELECT * FROM " + TableConstant.OFFER_TABLE;
        
        public final static String GET_ALL_OFFER_BY_ID = " SELECT * FROM " + TableConstant.OFFER_TABLE+
                " WHERE offerid=?";
        public final static String UPDATE_OFFER_DETAILS = "UPDATE " + TableConstant.OFFER_TABLE+
                " SET type=?,ordercount=?,pricetag=? where offerid=?";
        
        public final static String DELETE_OFFER = "DELETE FROM " + TableConstant.OFFER_TABLE+
                " WHERE offerid=?";
        
        
    }
    
    public class Offers_Users{
        
        public final static String OFFERS_USERS_INSERT = " INSERT INTO " + TableConstant.OFFER_USERS_TABLE+
                " VALUES(?,?,?)";
        
        public final static String GET_USER_OFFER_BOUGHT = " SELECT * FROM " + TableConstant.OFFER_USERS_TABLE+
                " WHERE username=? and offerid=?";
        
        public final static String GET_USER_OFFER = "select * from offers_users ou, offers o where o.offerid=ou.offerid and username=?";

        public final static String GET_ALL_USER_OFFER = "select * from offers_users ou, offers o where o.offerid=ou.offerid";
        
    }
    
    public class Package{
        
        public final static String PACKAGE_INSERT = "insert into " + TableConstant.PACKAGE_TABLE +
                " values(?,?,?,?)";
        
        public final static String PACKAGE_ITEM_INSERT = "INSERT INTO " + TableConstant.PACKAGE_ITEM_TABLE +
                " (packageId,productId,oldPrice,newPrice) values(?,?,?,?)";
        
        public final static String GET_ALL_PACKAGE = "SELECT * FROM " + TableConstant.PACKAGE_TABLE;
        
        public final static String GET_PACKAGE_BY_ID = "select * from " + TableConstant.PACKAGE_ITEM_TABLE+
                " where packageId=?";
    }
    
    public class PackageBought{
        
        public final static String INSERT_PACKAGE_BOUGHT = "INSERT INTO " + TableConstant.PACKAGE_BOUGHT+
                " values(?,?,?)";
        
       public final static String GET_ALL_USER_BOUGHT_PACAKGE = "SELECT * FROM packagebought pb,package p where pb.packageId=p.packageid and username=?";
       
       public final static String GET_ALL_BOUGHT_PACAKGE = "SELECT * FROM packagebought pb,package p where pb.packageId=p.packageid order by date desc";
       
       public final static String GET_ALL_PACKAGE = "SELECT * FROM " +TableConstant.PACKAGE_TABLE;

       
    }
    
    public class RechargeDebitAmount{
        public final static String REGISTER_DEBIT_AMOUNT="INSERT INTO " + TableConstant.RECHARGE_DEBIT_AMOUNT_TABLE+
                " (rechargeAmount,rechargeToken,status) values(?,?,false)";
        
        public final static String PLUS_DEBIT_AMOUNT = "UPDATE " + TableConstant.USER_TABLE +
                " SET debitamount=debitamount+? WHERE username=?";
        
        public final static String GET_PIN_AMOUNT = " SELECT rechargeAmount FROM " + TableConstant.RECHARGE_DEBIT_AMOUNT_TABLE+
                " WHERE rechargeToken=?";
        
        public final static String UPDATE_PIN_STATUS = "UPDATE " + TableConstant.RECHARGE_DEBIT_AMOUNT_TABLE+
                " SET status=true where rechargeToken=?";
    }
    
}
