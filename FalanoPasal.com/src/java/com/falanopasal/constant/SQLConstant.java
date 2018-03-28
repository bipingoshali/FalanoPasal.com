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
                + "addressline1,addressline2,houseno,phoneno,birthdate,roleid,status,emailToken)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        public final static String IS_USERNAME_EXIST = "SELECT COUNT(username) FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";
        
        public final static String GET_BY_USERNAME = "SELECT * FROM "
                + TableConstant.USER_TABLE +
                " WHERE username=?";
        
        public final static String EMAIL_TOKEN_UPDATE = "UPDATE " + TableConstant.USER_TABLE +
                " SET emailToken=? where username=?";
        
        public final static String GET_BY_USERID = "SELECT * FROM "
                +TableConstant.USER_TABLE+
                " where userId=?";
        
        public final static String UPDATE_USER_STATUS = "UPDATE " + TableConstant.USER_TABLE +
                " set status=true where userId=?";
        
        
        public final static String USERNAME_AUTHENTICATION = "SELECT * FROM "
                +TableConstant.USER_TABLE+
                " WHERE username=?";

    }
}
