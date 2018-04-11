/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.DeliveryDAO;
import com.falanopasal.entity.Delivery;
import com.falanopasal.service.DeliveryService;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryDAO deliveryDao;

    @Override
    public void insert(Delivery delivery) throws SQLException, ClassNotFoundException, ParseException {

        if (delivery.getDeliveryType().equals("custom")) {
            //converting date datatype
            Date utilCustomDate = new SimpleDateFormat("yyyy-MM-dd").parse(delivery.getCustomDate());
            java.sql.Date sqlCustomDate = new java.sql.Date(utilCustomDate.getTime());
            delivery.setCustomDateFormat(sqlCustomDate);

            Date utilCustomTime = new SimpleDateFormat("h:mm").parse(delivery.getCustomTime());
            java.sql.Time sqlCustomTime = new java.sql.Time(utilCustomTime.getTime());
            delivery.setCustomTimeFormat(sqlCustomTime);
        } else {
            Date utilQuickDate = new Date();
            java.sql.Date sqlQuickDate = new java.sql.Date(utilQuickDate.getTime());
            delivery.setCustomDateFormat(sqlQuickDate);
            
            Time utilQuickTime = new Time(0);
            java.sql.Time sqlQuickTime = new java.sql.Time(utilQuickTime.getTime());
            delivery.setCustomTimeFormat(sqlQuickTime);
        }

        deliveryDao.insert(delivery);
    }

}
