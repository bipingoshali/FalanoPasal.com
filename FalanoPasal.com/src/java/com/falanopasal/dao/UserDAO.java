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
    
    //update order count
    void updateOrderCount(String username) throws SQLException,ClassNotFoundException;
    
    //update user password
    void updateUserPassword(User user) throws SQLException,ClassNotFoundException;
    
    //get total calorie value
    int getTotalCalorieValue(String username) throws SQLException,ClassNotFoundException;
    
    //check whether the user has shopped from the website or not
    boolean isUsernameShopped(String username) throws SQLException,ClassNotFoundException;
    
    //register debit amount
    void registerDebitAmount(User user) throws SQLException,ClassNotFoundException;
    
    //get recharge amount
    int getRechargeAmount(String rechargeToken) throws SQLException,ClassNotFoundException;
    
    //update user debit amount
    void updateUserDebitAmount(User user) throws SQLException,ClassNotFoundException;
    
    //update pin status
    void updatePinStatus(String rechargeToken) throws SQLException,ClassNotFoundException;
    
    //get total expense of user
    int getTotalExpense(String username) throws SQLException,ClassNotFoundException;
    

}
