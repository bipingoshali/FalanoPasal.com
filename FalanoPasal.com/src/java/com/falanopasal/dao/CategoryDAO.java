/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface CategoryDAO {
        
    //get category data 
    List<Category> getCategory() throws SQLException,ClassNotFoundException;
    
    

}
