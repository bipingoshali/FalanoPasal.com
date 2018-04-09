/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.ProductDAO;
import com.falanopasal.entity.Product;
import com.falanopasal.service.ProductService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDao;
    
    @Override
    public List<Product> getProduct() throws SQLException, ClassNotFoundException {
        return productDao.getProduct();
    }

    @Override
    public Product getProductByProductId(int productId) throws SQLException, ClassNotFoundException {
        return productDao.getProductByProductId(productId);
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) throws SQLException, ClassNotFoundException {
        return productDao.getProductByCategoryId(categoryId);
    }

    @Override
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        productDao.insertProduct(product);
    }

    @Override
    public void editProduct(Product product) throws SQLException, ClassNotFoundException {
        productDao.editProduct(product);
    }

    @Override
    public void updateProductStock(Product product) throws SQLException, ClassNotFoundException {
        productDao.updateProductStock(product);
    }

    @Override
    public void updateProductCategoryId(Product product) throws SQLException, ClassNotFoundException {
        productDao.updateProductCategoryId(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException, ClassNotFoundException {
        productDao.deleteProduct(productId);
    }

    @Override
    public void rateProduct(Product product) throws SQLException, ClassNotFoundException {
        productDao.rateProduct(product);
    }

    @Override
    public void commentProduct(Product product) throws SQLException, ClassNotFoundException {
        productDao.commentProduct(product);
    }

    @Override
    public List<Product> getAllProductCommentByProductId(int productId) throws SQLException, ClassNotFoundException {
        return productDao.getAllProductCommentByProductId(productId);
    }

    @Override
    public void subscribeProduct(Product product) throws SQLException, ClassNotFoundException {
        productDao.subscribeProduct(product);
    }

    
}
