/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.CategoryDAO;
import com.falanopasal.entity.Category;
import com.falanopasal.service.CategoryService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDao;
    
    @Override
    public List<Category> getCategory() throws SQLException, ClassNotFoundException {
        return categoryDao.getCategory();
    }
    
}
