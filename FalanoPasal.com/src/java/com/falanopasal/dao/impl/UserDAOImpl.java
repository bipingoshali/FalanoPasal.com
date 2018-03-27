/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.UserDAO;
import com.falanopasal.entity.User;
import java.sql.SQLException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class UserDAOImpl implements UserDAO{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) throws SQLException, ClassNotFoundException, ParseException {
        return jdbcTemplate.update(SQLConstant.User.USER_INSERT, new Object[]{
           user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getUsername(),
            user.getPassword(),
            user.getCity(),
            user.getAddressLine1(),
            user.getAddressLine2(),
            user.getHouseNo(),
            user.getPhoneNo(),
            user.getBirthdateformat(),
            user.getRoleId(),
            user.isStatus()
        });
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException {
        Integer count = jdbcTemplate.queryForObject(SQLConstant.User.IS_USERNAME_EXIST, new String[]{username}, Integer.class);
        if(count==1){
            return true;
        }
        return false;
    }
    
    
}
