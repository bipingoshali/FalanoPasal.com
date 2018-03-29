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
    
    //get value from session
    User getDataFromSessionValue(User user) throws SQLException,ClassNotFoundException;
    
}
