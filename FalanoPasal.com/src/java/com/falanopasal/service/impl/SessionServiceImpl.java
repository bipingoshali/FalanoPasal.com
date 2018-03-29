/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.SessionDAO;
import com.falanopasal.entity.User;
import com.falanopasal.service.SessionService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class SessionServiceImpl implements SessionService{
    
    @Autowired
    private SessionDAO sessionDao;

    @Override
    public User getDataFromSessionValue(User user) throws SQLException, ClassNotFoundException {        
        return sessionDao.getDataFromSessionValue(user);
    }
}
