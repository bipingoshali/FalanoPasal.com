/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.SessionDAO;
import com.falanopasal.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class SessionDAOImpl implements SessionDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public User getDataFromSessionValue(User user) throws SQLException, ClassNotFoundException {
        List<User> fetchDataFromSessionValue = jdbcTemplate.query(SQLConstant.User.GET_BY_USERNAME, new Object[]{user.getSessionValue()}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
        return fetchDataFromSessionValue.size() > 0 ? fetchDataFromSessionValue.get(0):null;
    }
    
    private User mapData(ResultSet rs) throws SQLException{
        User user = new User();
        user.setAddressLine1(rs.getString("addressLine1"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setRoleId(rs.getInt("roleId"));
        return user;
    }

//    @Override
//    public User getDataFromCookieValue(String username) throws SQLException, ClassNotFoundException {
//        List<User> fetchDataFromCookieValue = jdbcTemplate.query(SQLConstant.User.GET_BY_USERNAME, new Object[]{username}, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int i) throws SQLException {
//                return mapData(rs);
//            }
//        });
//        return fetchDataFromCookieValue.size() > 0 ? fetchDataFromCookieValue.get(0):null;
//    }


    @Override
    public User rememberMe(String token) throws SQLException, ClassNotFoundException {
        List<User> fetchDataWhenRememberMe = jdbcTemplate.query(SQLConstant.cookie.GET_BY_COOKIE_VALUE, new Object[]{token}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
        return fetchDataWhenRememberMe.size() > 0 ? fetchDataWhenRememberMe.get(0):null;        
    }

    @Override
    public void insertCookie(String token, String username) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.cookie.INSERT_COOKIE, new Object[]{username,token});
    }

    @Override
    public void deleteCookie(String username) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.cookie.DELETE_COOKIE, new Object[]{username});
    }


    
    
}
