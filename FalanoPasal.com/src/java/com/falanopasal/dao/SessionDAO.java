/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.User;
import java.sql.SQLException;

/**
 *
 * @author bipin
 */
public interface SessionDAO {
    
    //get user data from session value
    User getDataFromSessionValue(User user) throws SQLException,ClassNotFoundException;
    
//    User getDataFromCookieValue(String username) throws SQLException,ClassNotFoundException;
    
    //insert cookie inside user table
    void insertCookie(String token,String username) throws SQLException,ClassNotFoundException;
    
    //get user data form cookie value
    User rememberMe(String token) throws SQLException,ClassNotFoundException;
    
    //delete cookies
    void deleteCookie(String username) throws SQLException,ClassNotFoundException;
    
}
