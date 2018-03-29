/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.User;
import java.sql.SQLException;

/**
 *
 * @author bipin
 */
public interface SessionService {
    User getDataFromSessionValue(User user) throws SQLException,ClassNotFoundException; 
    User getDataFromCookieValue(String username) throws SQLException,ClassNotFoundException;  
    void insertCookie(String token,String username) throws SQLException,ClassNotFoundException;
    User rememberMe(String token) throws SQLException,ClassNotFoundException;
}
