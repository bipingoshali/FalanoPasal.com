/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.UserDAO;
import com.falanopasal.entity.Login;
import com.falanopasal.entity.User;
import com.falanopasal.service.UserService;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public int insert(User user) throws SQLException, ClassNotFoundException, ParseException {

        //converting date datatype
        Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(user.getBirthdate());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        user.setBirthdateformat(sqlDate);

        //setting the default role id in every registration
        user.setRoleId(2);
        
        //creating a random email token id 
        java.util.UUID randomUUID = java.util.UUID.randomUUID();
        String emailToken = randomUUID.toString();        
        user.setEmailToken(emailToken);

        //setting the default system date in user enroll date
        Date utilEnrollDate = new Date();
        java.sql.Date sqlEnrollDate = new java.sql.Date(utilEnrollDate.getTime());
        user.setEnrollDate(sqlEnrollDate);

        
        return userDao.insert(user);
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException {
        return userDao.isUsernameExist(username);
    }

    @Override
    public User getByUsername(User user) throws SQLException, ClassNotFoundException {
        return userDao.getByUsername(user);
    }

    @Override
    public User getByUserId(User user) throws SQLException, ClassNotFoundException {
        return userDao.getByUserId(user);
    }

    @Override
    public void updateUserStatus(int userId) throws SQLException, ClassNotFoundException {
        userDao.updateUserStatus(userId);
    }

    @Override
    public User usernameAuthentication(Login login) throws SQLException, ClassNotFoundException {
        return userDao.usernameAuthentication(login);
    }

    @Override
    public List<User> getAllCustomer() throws SQLException, ClassNotFoundException {
        return userDao.getAllCustomer();
    }

    @Override
    public void updateDebitAmount(User user) throws SQLException, ClassNotFoundException {
        userDao.updateDebitAmount(user);
    }

    @Override
    public void updateOrderCount(String username) throws SQLException, ClassNotFoundException {
        userDao.updateOrderCount(username);
    }

    @Override
    public void updateUserPassword(User user) throws SQLException, ClassNotFoundException {
        userDao.updateUserPassword(user);
    }

    @Override
    public int getTotalCalorieValue(String username) throws SQLException, ClassNotFoundException {
        return userDao.getTotalCalorieValue(username);
    }

    @Override
    public boolean isUsernameShopped(String username) throws SQLException, ClassNotFoundException {
        return userDao.isUsernameShopped(username);
    }

    @Override
    public void registerDebitAmount(User user) throws SQLException, ClassNotFoundException {
        userDao.registerDebitAmount(user);
    }

    @Override
    public int getRechargeAmount(String rechargeToken) throws SQLException, ClassNotFoundException {
        return userDao.getRechargeAmount(rechargeToken);
    }

    @Override
    public void updateUserDebitAmount(User user) throws SQLException, ClassNotFoundException {
        userDao.updateDebitAmount(user);
    }

    @Override
    public void updatePinStatus(String rechargeToken) throws SQLException, ClassNotFoundException {
        userDao.updatePinStatus(rechargeToken);
    }

    @Override
    public int getTotalExpense(String username) throws SQLException, ClassNotFoundException {
        return userDao.getTotalExpense(username);
    }

    @Override
    public int getCreditAmount(String username) throws SQLException, ClassNotFoundException {
        return userDao.getCreditAmount(username);
    }

    @Override
    public boolean checkUserCredit(String username) throws SQLException, ClassNotFoundException {
        return userDao.checkUserCredit(username);
    }


   

}
