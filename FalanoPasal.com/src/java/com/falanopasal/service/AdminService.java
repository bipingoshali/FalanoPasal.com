/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.Category;
import com.falanopasal.entity.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface AdminService {
    List<Category> getCategory() throws SQLException,ClassNotFoundException;  
    void insertProduct(Product product) throws SQLException,ClassNotFoundException;
    List<Product> getProduct() throws SQLException,ClassNotFoundException;    
    List<Product> getProductByCategoryId(int categoryId) throws SQLException,ClassNotFoundException;
    void insertCategory(Category category) throws SQLException,ClassNotFoundException;    
    Product getProductById(int productId) throws SQLException,ClassNotFoundException;
    void editProduct(Product product) throws SQLException,ClassNotFoundException; 
    void updateProductStock(Product product) throws SQLException, ClassNotFoundException;
    void updateProductCategoryType(Product product) throws SQLException,ClassNotFoundException;   
    void deleteProduct(int productId) throws SQLException,ClassNotFoundException;
}
