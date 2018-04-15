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
    
    @Autowired
    private ApplicationContext appContext;
    
    
    
    
    private SessionManager sessionManager; //session data    
    private User userCookie; // to store user data obtained from cookie value
    private User userSessionSet; // session value is set in User Entity(username)
    private User userSessionGet; // to fetch user data
    private User fetchUserList; // to store user data which will be used while sending mail
    int counter=0; // to count the login Attempt
    
    
    
    
    
    /*
    main home page controller
    it opens the index page    
    */
    @RequestMapping(value= {"/","/index"})
    public ModelAndView index(@CookieValue(value="falanoPasal",defaultValue="defaultValue") String cookieValue) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/index");
        ModelAndView userModel =  new ModelAndView("redirect:/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        
        sessionManager = new SessionManager();
        
        userCookie = new User();
        userCookie = sessionService.rememberMe(cookieValue);
        
        //if a cookie is present
        if(userCookie!=null){
            sessionManager.setData(new String[]{"username"},new String[]{userCookie.getUsername()});
            return userModel; //default redirect page
        }else{
            if (sessionManager.getAttr("username") != null) {
                String username = sessionManager.getAttr("username").toString();
                userSessionSet = new User();
                userSessionSet.setSessionValue(username); //setting username to find out the user role ID
                userSessionGet = new User();
                userSessionGet = sessionService.getDataFromSessionValue(userSessionSet); // userSessionGet holds all the value of the User
                
                if(userSessionGet.getRoleId()==1){
                    return adminModel;
                } else {
                    return userModel;
                }
            }            
        }        
        return model;        
    }

    
    
    
    
    /*
    registration page controller
    it opens register page
    */
    @RequestMapping("/register")
    public ModelAndView register(@CookieValue(value="falanoPasal",defaultValue="defaultValue") String cookieValue) throws SQLException, ClassNotFoundException {
        ModelAndView model = new ModelAndView("/register");
        ModelAndView userModel =  new ModelAndView("redirect:/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");        
        sessionManager = new SessionManager();
        userCookie = new User();
        userCookie = sessionService.rememberMe(cookieValue);
        
        //if a cookie is present
        if(userCookie!=null){
            sessionManager.setData(new String[]{"username"},new String[]{userCookie.getUsername()});
            return userModel; //default redirect page
        }else{
            if (sessionManager.getAttr("username") != null) {
                String username = sessionManager.getAttr("username").toString();
                userSessionSet = new User();
                userSessionSet.setSessionValue(username); //setting username to find out the user role ID
                userSessionGet = new User();
                userSessionGet = sessionService.getDataFromSessionValue(userSessionSet); // userSessionGet holds all the value of the User

                if (userSessionGet.getRoleId() == 1) {
                    return adminModel;
                } else {
                    return userModel;
                }
            }            
        }

        model.addObject("user", new User());
        return model;
    }
             
    /*
    it saves the user data 
    it fetch the user data after insertion which will be used while sending mail
    */
    @RequestMapping(value="/registerSave",method=RequestMethod.POST)
    public String registerSave(@ModelAttribute("user") User user,final RedirectAttributes redirectAttributes) throws SQLException,ClassNotFoundException,ParseException{
        userService.insert(user);
        fetchUserList = new User();
        fetchUserList = userService.getByUsername(user);
        
        //creating a random user id 
        java.util.UUID randomUUID = java.util.UUID.randomUUID();
        String emailToken = randomUUID.toString();
        
        String msg = "Congratulation "+user.getUsername()+"! Your account has been created. \n";
        msg+= "Your Address :"+user.getCity()+", "+user.getAddressLine1()+", "+user.getAddressLine2()+" "+user.getHouseNo()+" \n";
        msg+= "Please click the link below to verify your email address. \n";
        msg+= "http://localhost:8080/FalanoPasal.com/confirmEmail?token="+fetchUserList.getEmailToken()+"&userId="+fetchUserList.getUserId();
        Mail sMail = (Mail) appContext.getBean("mail");
        sMail.sendMail("bipingoshali2527@gmail.com", user.getEmail(), "FalanoPasal.com", msg);
        redirectAttributes.addFlashAttribute("message", "Congratulation! Your account has been created. Please verify your email address.");        
        return "redirect:/register";
    }
    
    /*
    checks whether the username is available or not
    */
    @RequestMapping(value="/check_username")
    public @ResponseBody String checkUsernameAvailability(@RequestParam String username) throws SQLException, ClassNotFoundException{
        if(userService.isUsernameExist(username)){
            return "Username already taken!";
        }
        return null;
    }
    
    /*
    activate the user account
    */
    @RequestMapping(value="/confirmEmail")
    public @ResponseBody ModelAndView updateUserStatus(@RequestParam("token") String token,@RequestParam("userId") int userId,final RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/login");    
        User user = new User();
        user.setUserId(userId);
        User fetchUserStatusForStatusCheck = userService.getByUserId(user);
        
        //fetching email token which is stored in database
        String fetchEmailToken = fetchUserStatusForStatusCheck.getEmailToken();
        
        //if the user account is already activated
        if(fetchUserStatusForStatusCheck.isStatus()){
            redirectAttributes.addFlashAttribute("message", "Your account has already been activated!");
        }else{
            if(token.equals(fetchEmailToken)) {
                userService.updateUserStatus(userId);
                redirectAttributes.addFlashAttribute("message", "Congratulation! Your account has been activated!");
            }            
        }    
        return model;
    }
    
//    end of registration page controller
    
    
    
    
    
    
    /*
    login page controller
    it opens login page
    */        
    @RequestMapping("/login")
    public ModelAndView login(@CookieValue(value="falanoPasal",defaultValue="defaultValue") String cookieValue) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/login");
        ModelAndView userModel =  new ModelAndView("redirect:/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        
        sessionManager = new SessionManager();
        
        userCookie = new User();
        userCookie = sessionService.rememberMe(cookieValue);
        
        //if a cookie is present
        if(userCookie!=null){
            sessionManager.setData(new String[]{"username"},new String[]{userCookie.getUsername()});
            return userModel; //default redirect page
        }else{
            if (sessionManager.getAttr("username") != null) {
                String username = sessionManager.getAttr("username").toString();
                userSessionSet = new User();
                userSessionSet.setSessionValue(username); //setting username to find out the user role ID
                userSessionGet = new User();
                userSessionGet = sessionService.getDataFromSessionValue(userSessionSet); // userSessionGet holds all the value of the User
                
                if(userSessionGet.getRoleId()==1){
                    return adminModel;
                } else {
                    return userModel;
                }
            }            
        }
        
        model.addObject("login", new Login());
        return model;
    }
    
    /*
    it authenticates the username and password
    */
    @RequestMapping(value="/checkLogin",method=RequestMethod.POST)
    public ModelAndView userAuthentication(@ModelAttribute("login") Login login,final RedirectAttributes redirectAttributes,HttpServletResponse response,@CookieValue(value="loginAttempt",defaultValue="0") String cookieValue) throws SQLException, ClassNotFoundException{
        ModelAndView userModel = new ModelAndView("redirect:/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        ModelAndView loginModel = new ModelAndView("redirect:/login");
        
        User user = userService.usernameAuthentication(login);
        if(user!=null){
            if(user.isStatus()){
                
                //works if the user login attempt is failed for 3 times
                if(Integer.parseInt(cookieValue)==3){
                    redirectAttributes.addFlashAttribute("message", "You have been blocked for 2 minutes!");
                    return loginModel;
                }
                
                if(login.getPassword().equals(user.getPassword())) {
                    sessionManager = new SessionManager();
                    //assigning only one value in every session in order to reduce memory consumption
                    sessionManager.setData(new String[]{"username"}, new String[]{login.getUsername()});
                    
                    if (login.isRememberme()) {
                        java.util.UUID randomUUID = java.util.UUID.randomUUID();
                        Cookie falanoPasalCookie = new Cookie("falanoPasal", randomUUID.toString());
                        falanoPasalCookie.setMaxAge(60 * 5);
                        response.addCookie(falanoPasalCookie);
                        sessionService.insertCookie(randomUUID.toString(), login.getUsername());
                        counter=0; //setting the default value of counter
                    }

                    if (user.getRoleId() == 1) {
                        counter=0;
                        return adminModel;
                    }else{
                        counter=0;
                        return userModel;                                                            
                    }
                }
                counter++;
                if(counter==3){
                    Cookie loginAttempt = new Cookie("loginAttempt",String.valueOf(counter));
                    loginAttempt.setMaxAge(60*2);
                    response.addCookie(loginAttempt);
                    counter=0;
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
    
    /*
    user logout
    */
    @RequestMapping(value="/logout")
    public ModelAndView logout(@CookieValue(value="falanoPasal",defaultValue="defaultValue") String cookieValue,HttpServletResponse response) throws SQLException, ClassNotFoundException{
        sessionManager = new SessionManager();
        String username = sessionManager.getAttr("username").toString();        
        sessionService.deleteCookie(username);
        sessionManager.clearData();
        
        //the following code runs if the cookie is present
        if(cookieValue!=null){
            Cookie adminCookie = new Cookie("falanoPasal", "");
            adminCookie.setMaxAge(0);
            response.addCookie(adminCookie);            
        }
        return new ModelAndView("redirect:/login");
    }
    
//    end of login and logout function
        
}
