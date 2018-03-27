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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDAO userDao;

    @Override
    public int insert(User user) throws SQLException, ClassNotFoundException, ParseException {
        
        //converting date datatype
        Date utilDate = new SimpleDateFormat("yyyy-mm-dd").parse(user.getBirthdate());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        user.setBirthdateformat(sqlDate);
        
        //setting the default role id in every registration
        user.setRoleId(1);

        return userDao.insert(user);
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException {
        return userDao.isUsernameExist(username);
    }
    
    
}
