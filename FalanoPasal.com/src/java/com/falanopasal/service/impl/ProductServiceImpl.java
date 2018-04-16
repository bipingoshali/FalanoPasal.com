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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException,ParseException {
        
        //converting date datatype
        Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(product.getManufacturedDate());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        product.setManufactureDateFormat(sqlDate);
        
        productDao.insertProduct(product);
    }

    @Override
    public void editProduct(Product product) throws SQLException, ClassNotFoundException,ParseException {
                
        //converting string into util date format
        Date utilMDate = new SimpleDateFormat("yyyy-MM-dd").parse(product.getManufacturedDate());
        java.sql.Date sqlMDate = new java.sql.Date(utilMDate.getTime());
        //setting the sql date format
        product.setManufactureDateFormat(sqlMDate);
        
        Date utilEDate = new SimpleDateFormat("yyyy-MM-dd").parse(product.getExpiryDateStringFormat());
        java.sql.Date sqlEDate = new java.sql.Date(utilEDate.getTime());
        product.setExpiryDateFormat(sqlEDate);
        

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
        //setting the default system date in rating date
        Date utilRateDate = new Date();
        java.sql.Date sqlRateDate = new java.sql.Date(utilRateDate.getTime());
        product.setProductRateDate(sqlRateDate);
        
        productDao.rateProduct(product);
    }

    @Override
    public void commentProduct(Product product) throws SQLException, ClassNotFoundException {
        
        Date utilCommentDate = new Date();
        java.sql.Date sqlCommentDate = new java.sql.Date(utilCommentDate.getTime()); 
        product.setProductCommentDate(sqlCommentDate);
        
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

    @Override
    public void updateProductBought(Product product) throws SQLException, ClassNotFoundException {
        productDao.updateProductBought(product);
    }

    @Override
    public boolean checkUserRate(Product product) throws SQLException, ClassNotFoundException {
        return productDao.checkUserRate(product);
    }

    @Override
    public void updateUserRateForAProduct(Product product) throws SQLException, ClassNotFoundException {
        //setting the default system date in rating date
        Date utilRateDate = new Date();
        java.sql.Date sqlEnrollDate = new java.sql.Date(utilRateDate.getTime());
        product.setProductRateDate(sqlEnrollDate);
        
        productDao.updateUserRateForAProduct(product);
    }

    @Override
    public int getUserRating(Product product) throws SQLException, ClassNotFoundException {
        return productDao.getUserRating(product);
    }

    @Override
    public float getProductRating() throws SQLException, ClassNotFoundException {
        return productDao.getProductRating();
    }

    @Override
    public List<Product> getProductByPrice() throws SQLException, ClassNotFoundException {
        return productDao.getProductByPrice();
    }

    @Override
    public List<Product> getProductByPopularity() throws SQLException, ClassNotFoundException {
        return productDao.getProductByPopularity();
    }

    @Override
    public List<Product> getSubscriptionListByUsername(String username) throws SQLException, ClassNotFoundException {
        return productDao.getSubscriptionListByUsername(username);
    }

    @Override
    public List<Product> getAllSubscriptionList() throws SQLException, ClassNotFoundException {
        return productDao.getAllSubscriptionList();
    }

    @Override
    public void pauseSubscription(Product product) throws SQLException, ClassNotFoundException {
        productDao.pauseSubscription(product);
    }

    @Override
    public void startSubscription(Product product) throws SQLException, ClassNotFoundException {
        productDao.startSubscription(product);
    }

    @Override
    public void cancelSubscription(Product product) throws SQLException, ClassNotFoundException {
        productDao.cancelSubscription(product);
    }

    
}
