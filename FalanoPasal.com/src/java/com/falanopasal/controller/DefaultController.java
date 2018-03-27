/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.User;
import com.falanopasal.service.UserService;
import java.sql.SQLException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bipin
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value= {"/","/index"})
    public String index(){
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView model = new ModelAndView("/register");
        model.addObject("user", new User());
        return model;
    }
    
    @RequestMapping(value="/registerSave",method=RequestMethod.POST)
    public String registerSave(@ModelAttribute("user") User user,final RedirectAttributes redirectAttributes) throws SQLException,ClassNotFoundException,ParseException{
        userService.insert(user);
        redirectAttributes.addFlashAttribute("message", "Congratulation! Your account has been created. Please verify your email address.");        
        return "redirect:/register";
    }
    
    @RequestMapping(value="/check_username")
    public @ResponseBody String checkUsernameAvailability(@RequestParam String username) throws SQLException, ClassNotFoundException{
        if(userService.isUsernameExist(username)){
            return "Username already taken!";
        }
        return null;
    }
}
