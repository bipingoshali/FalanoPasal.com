/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author bipin
 */
public class SessionManager {
    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
    HttpServletRequest request = attributes.getRequest();
    HttpSession httpSession = request.getSession();

    public void setData(String [] key,String [] data){
        for(int i=0;i<key.length;i++){
            httpSession.setAttribute(key[i], data[i]);
        }
    }
    
    public Object getAttr(String key){
        return httpSession.getAttribute(key);
    }
    
    public void clearData(){
        httpSession.invalidate();
    }    
}
