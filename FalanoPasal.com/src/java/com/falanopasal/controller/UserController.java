/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.User;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bipin
 */
@Controller
@RequestMapping(value="/")
public class UserController {    
    
    private SessionManager sessionManager;
    
    @RequestMapping("/user/home")
    public ModelAndView userHomePage(final RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException{
        ModelAndView model =  new ModelAndView("/user/home");
        sessionManager = new SessionManager();
        String roleId = sessionManager.getAttr("roleId").toString();
//        redirectAttributes.addFlashAttribute("message", roleId);
//        String username = session.getAttribute("username").toString();
        model.addObject("hello", roleId);
        return model;
    }
}
