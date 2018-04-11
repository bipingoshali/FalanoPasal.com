/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.DeliveryDAO;
import com.falanopasal.entity.Delivery;
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
public class DeliveryDAOImpl implements DeliveryDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void insert(Delivery delivery) throws SQLException, ClassNotFoundException,ParseException {
        jdbcTemplate.update(SQLConstant.Delivery.DELIVERY_INSERT, new Object[]{delivery.getCartId(),
        delivery.getDeliveryType(),
        delivery.getCustomDateFormat(),        
        delivery.getCustomTimeFormat()});
    }
    
}
