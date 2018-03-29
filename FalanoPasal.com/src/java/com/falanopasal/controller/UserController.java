/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.User;
import com.falanopasal.service.SessionService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bipin
 */
@Controller
@RequestMapping(value="/")
public class UserController {    
    
    @Autowired
    private SessionService sessionService;
    
    private SessionManager sessionManager;
    
    @RequestMapping("/user/home")
    public ModelAndView userHomePage() throws SQLException, ClassNotFoundException{
        ModelAndView userModel =  new ModelAndView("/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            User user = new User();
            user.setSessionValue(username);
            User fetchSessionData;
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if(fetchSessionData.getRoleId()==1){
                return adminModel;
            }else{
                return userModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
}
