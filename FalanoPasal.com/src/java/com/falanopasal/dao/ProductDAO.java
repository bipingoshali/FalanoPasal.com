/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.Product;
import java.sql.SQLException;
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
    void insertProduct(Product product) throws SQLException,ClassNotFoundException;

    //edit product data
    void editProduct(Product product) throws SQLException,ClassNotFoundException;

    //update stock value of any product
    void updateProductStock(Product product) throws SQLException, ClassNotFoundException;
    
    //update product category type
    void updateProductCategoryId(Product product) throws SQLException,ClassNotFoundException;
    
    //delete product
    void deleteProduct(int productId) throws SQLException,ClassNotFoundException;
    
    
    
    
}
