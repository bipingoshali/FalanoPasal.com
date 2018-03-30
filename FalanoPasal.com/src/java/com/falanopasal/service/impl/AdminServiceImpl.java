/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.AdminDAO;
import com.falanopasal.entity.Category;
import com.falanopasal.entity.Product;
import com.falanopasal.service.AdminService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class AdminServiceImpl implements AdminService{
    
    @Autowired
    private AdminDAO adminDao;

    @Override
    public List<Category> getCategory() throws SQLException, ClassNotFoundException {
        return adminDao.getCategory();
    }

    @Override
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        adminDao.insertProduct(product);
    }

    @Override
    public List<Product> getProduct() throws SQLException, ClassNotFoundException {
        return adminDao.getProduct();
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) throws SQLException, ClassNotFoundException {
        return adminDao.getProductByCategoryId(categoryId);
    }
    
}
