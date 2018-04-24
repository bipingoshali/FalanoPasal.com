/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.Login;
import com.falanopasal.entity.User;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface UserService {
    int insert(User user) throws SQLException, ClassNotFoundException,  ParseException; 
    boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException;    
    User getByUsername(User user) throws SQLException, ClassNotFoundException;    
    User getByUserId(User user) throws SQLException, ClassNotFoundException;   
    void updateUserStatus(int userId) throws SQLException,ClassNotFoundException; 
    User usernameAuthentication(Login login) throws SQLException,ClassNotFoundException;
    List<User> getAllCustomer() throws SQLException,ClassNotFoundException;
    void updateDebitAmount(User user) throws SQLException,ClassNotFoundException;
    void updateOrderCount(String username) throws SQLException,ClassNotFoundException;   
    void updateUserPassword(User user) throws SQLException,ClassNotFoundException;  
    int getTotalCalorieValue(String username) throws SQLException,ClassNotFoundException;    
    boolean isUsernameShopped(String username) throws SQLException,ClassNotFoundException;    
    void registerDebitAmount(User user) throws SQLException,ClassNotFoundException;
    int getRechargeAmount(String rechargeToken) throws SQLException,ClassNotFoundException;
    void updateUserDebitAmount(User user) throws SQLException,ClassNotFoundException;
    void updatePinStatus(String rechargeToken) throws SQLException,ClassNotFoundException;
    int getTotalExpense(String username) throws SQLException,ClassNotFoundException;    
}
