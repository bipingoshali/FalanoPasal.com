/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.Login;
import com.falanopasal.entity.User;
import com.falanopasal.service.SessionService;
import com.falanopasal.service.UserService;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
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
    private SessionService sessionService;
    
//    @Autowired
//    private ApplicationContext appContext;
    
    private SessionManager sessionManager;
    
    @RequestMapping(value= {"/","/index"})
    public String index(){
        return "index";
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
    
    @RequestMapping("/login")
    public ModelAndView login(@CookieValue(value="testA",defaultValue="defaultValue") String cookieValue) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/login");
        sessionManager = new SessionManager();
        User user = sessionService.rememberMe(cookieValue);
        if(user!=null){
            sessionManager.setData(new String[]{"username"},new String[]{user.getUsername()});                              
            return new ModelAndView("redirect:/user/home");
        }
        model.addObject("login", new Login());
        return model;
    }
    
    @RequestMapping(value="/checkLogin",method=RequestMethod.POST)
    public ModelAndView userAuthentication(@ModelAttribute("login") Login login,final RedirectAttributes redirectAttributes,HttpServletResponse response) throws SQLException, ClassNotFoundException{
        ModelAndView userModel = new ModelAndView("redirect:/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        ModelAndView loginModel = new ModelAndView("redirect:/login");
        
        User user = userService.usernameAuthentication(login);
        if(user!=null){
            if(user.isStatus()){
                if(login.getPassword().equals(user.getPassword())) {
                    sessionManager = new SessionManager();

                    //assigning only one value in every session in order to reduce memory consumption
                    sessionManager.setData(new String[]{"username"}, new String[]{login.getUsername()});
                    if (login.isRememberme()) {
                        java.util.UUID randomUUID = java.util.UUID.randomUUID();
                        Cookie adminCookie = new Cookie("testA", randomUUID.toString());
                        adminCookie.setMaxAge(60 * 2);
                        response.addCookie(adminCookie);
                        sessionService.insertCookie(randomUUID.toString(), login.getUsername());
                    }

                    if (user.getRoleId() == 1) {
                        return adminModel;
                    }else{
                        return userModel;                                                            
                    }
                }
                redirectAttributes.addFlashAttribute("message", "Password doesn't match!");
                return loginModel;
            }
            redirectAttributes.addFlashAttribute("message", "Please verify your email address!");
            return loginModel;
        }
        redirectAttributes.addFlashAttribute("message", "Username does not exist!");
        return loginModel;
    }
    
    @RequestMapping(value="/logout")
    public ModelAndView displaylogin(HttpServletResponse response){
        sessionManager = new SessionManager();
        sessionManager.clearData();
        Cookie adminCookie = new Cookie("testA", "");
        adminCookie.setMaxAge(0);
        response.addCookie(adminCookie);
        return new ModelAndView("redirect:/login");
    }
    
}
