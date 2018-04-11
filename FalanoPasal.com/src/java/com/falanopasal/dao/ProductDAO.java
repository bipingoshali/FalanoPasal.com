/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.Product;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface ProductDAO {
    //get product data
    List<Product> getProduct() throws SQLException,ClassNotFoundException;
    
    //get product data by product id
    Product getProductByProductId(int productId) throws SQLException,ClassNotFoundException;
    
    //get product data by category id
    List<Product> getProductByCategoryId(int categoryId) throws SQLException,ClassNotFoundException;
    
    //insert product data 
    void insertProduct(Product product) throws SQLException,ClassNotFoundException,ParseException;

    //edit product data
    void editProduct(Product product) throws SQLException,ClassNotFoundException,ParseException;

    //update stock value of any product
    void updateProductStock(Product product) throws SQLException, ClassNotFoundException;
    
    //update product category type
    void updateProductCategoryId(Product product) throws SQLException,ClassNotFoundException;
    
    //delete product
    void deleteProduct(int productId) throws SQLException,ClassNotFoundException;            
    
    //rate product
    void rateProduct(Product product) throws SQLException,ClassNotFoundException;
    
    //check if user has already rate the product
    boolean checkUserRate(Product product) throws SQLException,ClassNotFoundException;
    
    //update user rating for those product which user has already rated 
    //works if user want to rate again for that product
    void updateUserRateForAProduct(Product product) throws SQLException,ClassNotFoundException;
    
    //comment product
    void commentProduct(Product product) throws SQLException,ClassNotFoundException;
    
    //get all comment 
    List<Product> getAllProductCommentByProductId(int productId) throws SQLException,ClassNotFoundException;
    
    //subscribe product
    void subscribeProduct(Product product) throws SQLException,ClassNotFoundException;
    
    //it stores the total amount of product bought
    void updateProductBought(Product product) throws SQLException,ClassNotFoundException;
    
    
}
