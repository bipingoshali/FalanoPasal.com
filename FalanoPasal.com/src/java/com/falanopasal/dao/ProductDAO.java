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
    
}
