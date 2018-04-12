/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.Login;
import com.falanopasal.entity.User;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface UserDAO {
    
    //insert customer data
    int insert(User user) throws SQLException, ClassNotFoundException,  ParseException;    
    
    //check whether the username is available or not
    boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException;
    
    //get user details by username
    User getByUsername(User user) throws SQLException, ClassNotFoundException;
    
    //update user status
    User getByUserId(User user) throws SQLException, ClassNotFoundException;
    void updateUserStatus(int userId) throws SQLException,ClassNotFoundException;  
    
    //user authentication while login
    User usernameAuthentication(Login login) throws SQLException,ClassNotFoundException;
    
    //get all user
    List<User> getAllCustomer() throws SQLException,ClassNotFoundException;
    
    //update debit amount
    void updateDebitAmount(User user) throws SQLException,ClassNotFoundException;

}
