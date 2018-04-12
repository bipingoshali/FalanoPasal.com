/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author bipin
 */
public class Delivery {
    private int deliveryId;
    private String cartId;
    private String deliveryType;
    private String customDate,customTime;
    private Date customDateFormat;
    private Time customTimeFormat;
    private String payment;

    public Delivery() {
    }

    public Delivery(int deliveryId, String cartId, String deliveryType, String customDate, String customTime, Date customDateFormat, Time customTimeFormat, String payment) {
        this.deliveryId = deliveryId;
        this.cartId = cartId;
        this.deliveryType = deliveryType;
        this.customDate = customDate;
        this.customTime = customTime;
        this.customDateFormat = customDateFormat;
        this.customTimeFormat = customTimeFormat;
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCustomDate() {
        return customDate;
    }

    public void setCustomDate(String customDate) {
        this.customDate = customDate;
    }

    public String getCustomTime() {
        return customTime;
    }

    public void setCustomTime(String customTime) {
        this.customTime = customTime;
    }

    public Date getCustomDateFormat() {
        return customDateFormat;
    }

    public void setCustomDateFormat(Date customDateFormat) {
        this.customDateFormat = customDateFormat;
    }

    public Time getCustomTimeFormat() {
        return customTimeFormat;
    }

    public void setCustomTimeFormat(Time customTimeFormat) {
        this.customTimeFormat = customTimeFormat;
    }

    
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    
}
