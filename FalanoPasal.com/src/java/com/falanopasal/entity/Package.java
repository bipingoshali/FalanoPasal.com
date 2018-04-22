/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import java.util.Date;

/**
 *
 * @author bipin
 */
public class Package {
    private int productId;;
    private float oldPrice,newPrice;
    private String productName;
    private String packageId,packageName;
    private float grandTotalOld,grandTotalNew;
    private String username;
    private Date packageBoughtDate;

    public Package() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getPackageBoughtDate() {
        return packageBoughtDate;
    }

    public void setPackageBoughtDate(Date packageBoughtDate) {
        this.packageBoughtDate = packageBoughtDate;
    }

    public Package(int productId, float oldPrice, float newPrice, String productName, String packageId, String packageName, float grandTotalOld, float grandTotalNew, String username, Date packageBoughtDate) {
        this.productId = productId;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.productName = productName;
        this.packageId = packageId;
        this.packageName = packageName;
        this.grandTotalOld = grandTotalOld;
        this.grandTotalNew = grandTotalNew;
        this.username = username;
        this.packageBoughtDate = packageBoughtDate;
    }



    public float getGrandTotalOld() {
        return grandTotalOld;
    }

    public void setGrandTotalOld(float grandTotalOld) {
        this.grandTotalOld = grandTotalOld;
    }

    public float getGrandTotalNew() {
        return grandTotalNew;
    }

    public void setGrandTotalNew(float grandTotalNew) {
        this.grandTotalNew = grandTotalNew;
    }


    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }




    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(float newPrice) {
        this.newPrice = newPrice;
    }

    
    
    
}
