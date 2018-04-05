/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.Category;
import com.falanopasal.entity.Product;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.ShoppingCartMap;
import com.falanopasal.entity.User;
import com.falanopasal.service.CategoryService;
import com.falanopasal.service.OrderService;
import com.falanopasal.service.ProductService;
import com.falanopasal.service.SessionService;
import com.falanopasal.service.ShoppingCartHandlerService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ShoppingCartMap shoppingCartMap;
    
    @Autowired
    private ShoppingCartHandlerService shoppingCartHandlerService;
    
    @Autowired
    private OrderService orderService;
    
    private SessionManager sessionManager;
    private User user;
    private User fetchSessionData;
    
    @RequestMapping("/user/home")
    public ModelAndView userHomePage() throws SQLException, ClassNotFoundException{
        ModelAndView userModel =  new ModelAndView("/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            adminModel.addObject("username", username);
            user = new User();
            user.setSessionValue(username); //setting the session value in User entity
            fetchSessionData = new User();
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if(fetchSessionData.getRoleId()==1){                
                return adminModel;
            }else{
                List<Category> categoryList = categoryService.getCategory();
                List<Product> productList = productService.getProduct();
                userModel.addObject("categoryList", categoryList);
                userModel.addObject("productList", productList);
                return userModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
    @RequestMapping(value="/user/home-product-by-category-{categoryId}")
    public ModelAndView userHomePageSearchByCategory(@PathVariable("categoryId") int categoryId) throws SQLException, ClassNotFoundException{
        ModelAndView userModel =  new ModelAndView("/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            adminModel.addObject("username", username);
            user = new User();
            user.setSessionValue(username); //setting the session value in User entity
            fetchSessionData = new User();
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if(fetchSessionData.getRoleId()==1){                
                return adminModel;
            }else{
                List<Category> categoryList = categoryService.getCategory();
                List<Product> productList = productService.getProductByCategoryId(categoryId); //search product based on category
                userModel.addObject("categoryList", categoryList);
                userModel.addObject("productList", productList);
                return userModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
    
    @RequestMapping("/user/productDetail/{productId}")
    public ModelAndView productDetail(@PathVariable("productId") int productId) throws SQLException,ClassNotFoundException{
        ModelAndView userModel = new ModelAndView("/user/productDetail");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            user = new User();
            user.setSessionValue(username);
            fetchSessionData = new User();
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if(fetchSessionData.getRoleId()==1){
                return new ModelAndView("redirect:/admin/home");
            }else{
                Product product = productService.getProductByProductId(productId);
                if(product.getStockValue()==0){
                    userModel.addObject("message", "Out of stock");
                }
                userModel.addObject("product", product);
                return userModel;
            }           
        }
        return new ModelAndView("redirect:/login");
    }
    
    @RequestMapping(value="/user/productDetail/addToCart")
    public @ResponseBody void addToCart(@RequestParam(value="productId") int productId,@RequestParam(value="quantity") int quantity){
        shoppingCartMap.addItem(productId, quantity);
    }
    
    @RequestMapping(value="/user/shoppingCart")
    public ModelAndView shoppingCart() throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/user/shoppingCart");        
        List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries = shoppingCartHandlerService.getShoppingCartEntries(shoppingCartMap);
        model.addObject("shoppingCartHandlerEntries", shoppingCartHandlerEntries);
        model.addObject("grandTotal", shoppingCartHandlerService.getTotalPrice(shoppingCartHandlerEntries));
        model.addObject("shoppingItemSize", shoppingCartMap.getItemSize());
        model.addObject("totalCalorieValue", shoppingCartHandlerService.getTotalCalorie(shoppingCartHandlerEntries));
        return model;
    }   
    
    @RequestMapping(value="/user/shoppingCartOrder")
    public ModelAndView order() throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/user/shoppingCart");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            user = new User();
            user.setSessionValue(username);
            fetchSessionData = new User();
            fetchSessionData = sessionService.getDataFromSessionValue(user); 
            if(fetchSessionData.getRoleId()==1){
                return new ModelAndView("redirect:/admin/home");
            }else{
                List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries = shoppingCartHandlerService.getShoppingCartEntries(shoppingCartMap);
                java.util.UUID randomUUID = java.util.UUID.randomUUID();
                String cartId = randomUUID.toString();                
                orderService.registerUserShoppingCart(cartId,fetchSessionData.getUserId());
                orderService.registerUserShoppingCartItem(cartId,shoppingCartHandlerEntries);
                return model;
            }           
            
        }
//        orderService.order(shoppingCartHandlerEntries);
        return new ModelAndView("redirect:/login");
    }
    
}
