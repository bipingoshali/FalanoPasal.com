/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface CategoryService {
    
    //get category data 
    List<Category> getCategory() throws SQLException,ClassNotFoundException;

    //insert category data
    void insertCategory(Category category) throws SQLException,ClassNotFoundException;    

    //get category by id
    List<Category> getCategoryById(int categoryId) throws SQLException, ClassNotFoundException;
    
}
