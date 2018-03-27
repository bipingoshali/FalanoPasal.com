/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.constant;

/**
 *
 * @author bipin
 */
public class SQLConstant {
    
    public class User {

        public final static String USER_INSERT = "INSERT INTO "
                + TableConstant.USER_TABLE
                + " (firstName,lastName,email,username,password,city,"
                + "addressline1,addressline2,houseno,phoneno,birthdate,roleid,status)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        public final static String IS_USERNAME_EXIST = "SELECT COUNT(username) FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";

    }
}
