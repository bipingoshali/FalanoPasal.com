/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.Delivery;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author bipin
 */
public interface DeliveryService {
    //insert delivery option of the customer
    void insert(Delivery delivery) throws SQLException,ClassNotFoundException,ParseException;
    
}
