/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.UserDAO;
import com.falanopasal.entity.User;
import com.falanopasal.service.UserService;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.xml.security.utils.Base64;
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
        user.setRoleId(1);
        
        //creating a random email token id 
        java.util.UUID randomUUID = java.util.UUID.randomUUID();
        String emailToken = randomUUID.toString();        
        user.setEmailToken(emailToken);
        
        
        return userDao.insert(user);
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException {
        return userDao.isUsernameExist(username);
    }

    @Override
    public User getByEmail(User user) throws SQLException, ClassNotFoundException {
        return userDao.getByEmail(user);
    }

    @Override
    public void updateEmailToken(String token, String username) throws SQLException, ClassNotFoundException {
        userDao.updateEmailToken(token, username);
    }

    @Override
    public User getByUserId(User user) throws SQLException, ClassNotFoundException {
        return userDao.getByUserId(user);
    }

    @Override
    public void updateUserStatus(int userId) throws SQLException, ClassNotFoundException {
        userDao.updateUserStatus(userId);
    }

   

}
