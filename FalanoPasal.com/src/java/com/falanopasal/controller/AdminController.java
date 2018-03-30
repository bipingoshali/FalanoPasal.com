/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.Category;
import com.falanopasal.entity.Product;
import com.falanopasal.entity.User;
import com.falanopasal.service.AdminService;
import com.falanopasal.service.SessionService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bipin
 */
@Controller
@RequestMapping("/")
public class AdminController {
    
    @Autowired
    private SessionService sessionService;
    
    @Autowired
    private AdminService adminService;
    
    private SessionManager sessionManager;
    
    @RequestMapping("/admin/home")
    public ModelAndView adminHomePage() throws SQLException,ClassNotFoundException{
        ModelAndView adminModel = new ModelAndView("/admin/home");
        ModelAndView userModel = new ModelAndView("redirect:/user/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            User user = new User();
            user.setSessionValue(username);
            User fetchSessionData;
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if(fetchSessionData.getRoleId()==2){
                return userModel;
            }else{
                List<Product> productList = adminService.getProductByCategoryId(2);
                adminModel.addObject("productList", productList);
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
    @RequestMapping(value="/admin/product")
    public ModelAndView adminProductPage() throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/product");
        List<Category> categoryList = adminService.getCategory();
        List<Product> productList = adminService.getProduct();
        model.addObject("categoryList", categoryList);
        model.addObject("productList", productList);
        model.addObject("product", new Product());
        return model;
    }
    
    @RequestMapping(value="/admin/addProduct",method=RequestMethod.POST)
    public ModelAndView adminProductInsert(@ModelAttribute("product") Product product) throws SQLException,ClassNotFoundException{
        adminService.insertProduct(product);
        return new ModelAndView("redirect:/admin/product");
    }
    
    
}
