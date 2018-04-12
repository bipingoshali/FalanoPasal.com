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
public class User {
    
    private int userId;
    private String firstName,lastName,email,username,password,city,addressLine1,addressLine2,phoneNo,birthdate,familyType;
    private int houseNo,roleId;
    private boolean status=false; //setting the default value
    private Date birthdateformat,enrollDate;
    private String emailToken; //carries email token
    private String sessionValue; //caries session value
    private double debitAmount;
    private String cartId;
    private int orderCount;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String email, String username, String password, String city, String addressLine1, String addressLine2, String phoneNo, String birthdate, String familyType, int houseNo, int roleId, Date birthdateformat, Date enrollDate, String emailToken, String sessionValue, double debitAmount, String cartId, int orderCount) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.phoneNo = phoneNo;
        this.birthdate = birthdate;
        this.familyType = familyType;
        this.houseNo = houseNo;
        this.roleId = roleId;
        this.birthdateformat = birthdateformat;
        this.enrollDate = enrollDate;
        this.emailToken = emailToken;
        this.sessionValue = sessionValue;
        this.debitAmount = debitAmount;
        this.cartId = cartId;
        this.orderCount = orderCount;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }


    
    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }


    public String getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String familyType) {
        this.familyType = familyType;
    }


    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    
    public String getSessionValue() {
        return sessionValue;
    }

    public void setSessionValue(String sessionValue) {
        this.sessionValue = sessionValue;
    }
    
    
    public String getEmailToken(){
        return emailToken;
    }
    
    public void setEmailToken(String emailToken){
        this.emailToken = emailToken;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBirthdateformat() {
        return birthdateformat;
    }

    public void setBirthdateformat(Date birthdateformat) {
        this.birthdateformat = birthdateformat;
    }
    
    
    
}
