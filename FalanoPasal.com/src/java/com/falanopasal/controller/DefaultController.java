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
import org.springframework.context.ApplicationContext;
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
    
    @Autowired
    private ApplicationContext appContext;
    
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
        User fetchUserList = userService.getByEmail(user);
        
//        //creating a random user id 
//        java.util.UUID randomUUID = java.util.UUID.randomUUID();
//        String emailToken = randomUUID.toString();
//        
//        //update token value in user table
//        userService.updateEmailToken(emailToken, user.getUsername());

//        String msg = "Congratulation "+user.getUsername()+"! Your account has been created. \n";
//        msg+= "Your Address :"+user.getCity()+", "+user.getAddressLine1()+", "+user.getAddressLine2()+" "+user.getHouseNo()+" \n";
//        msg+= "Please click the link below to verify your email address. \n";
//        msg+= "http://localhost:8080/FalanoPasal.com/confirmEmail?token="+fetchUserList.getEmailToken()+"&userId="+fetchUserList.getUserId();
//        Mail sMail = (Mail) appContext.getBean("mail");
//        sMail.sendMail("bipingoshali2527@gmail.com", user.getEmail(), "FalanoPasal.com", msg);
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
    
    @RequestMapping(value="/confirmEmail")
    public @ResponseBody ModelAndView updateUserStatus(@RequestParam("token") String token,@RequestParam("userId") int userId) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/login");    
        User user = new User();
        user.setUserId(userId);
        User fetchUserStatusForStatusCheck = userService.getByUserId(user);
        
        //fetching email token stored in database
        String fetchEmailToken = fetchUserStatusForStatusCheck.getEmailToken();
        
        //if the user account is already activated
        if(fetchUserStatusForStatusCheck.isStatus()){
            model.addObject("hello", "your account has already been activated!");
        }else{
            if(token.equals(fetchEmailToken)) {
                userService.updateUserStatus(userId);
                model.addObject("hello", "your account has been activated!");
            }            
        }    
        return model;
    }
}
