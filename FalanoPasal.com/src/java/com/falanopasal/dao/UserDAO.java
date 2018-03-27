/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.User;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author bipin
 */
public interface UserDAO {
    
    //insert customer data
    int insert(User user) throws SQLException, ClassNotFoundException,  ParseException;    
    
    //check whether the username is available or not
    boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException;
}
