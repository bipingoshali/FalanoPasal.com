/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.Category;
import com.falanopasal.entity.Product;
import com.falanopasal.entity.ShoppingCart;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.ShoppingCartMap;
import com.falanopasal.entity.User;
import com.falanopasal.service.CategoryService;
import com.falanopasal.service.OrderService;
import com.falanopasal.service.ProductService;
import com.falanopasal.service.SessionService;
import com.falanopasal.service.ShoppingCartHandlerService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    private SessionManager sessionManager; //session values
    private User user; //to set session values (username)
    private User fetchSessionData; //fetch user values
    private ShoppingCart shoppingCart; //to register shopping cart
    
    /*
    it opens the registered user home page
    */
    @RequestMapping("/user/home")
    public ModelAndView userHomePage() throws SQLException, ClassNotFoundException{
        ModelAndView userModel =  new ModelAndView("/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
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
    
    /*
    search product based on category
    */
    @RequestMapping(value="/user/home-product-by-category-{categoryId}")
    public ModelAndView userHomePageSearchByCategory(@PathVariable("categoryId") int categoryId) throws SQLException, ClassNotFoundException{
        ModelAndView userModel =  new ModelAndView("/user/home");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
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
    
    /*
    view product details
    */
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
        
    
    /*
    it adds the products in shopping cart
    */
    @RequestMapping(value="/user/productDetail/addToCart")
    public @ResponseBody void addToCart(@RequestParam(value="productId") int productId,@RequestParam(value="quantity") int quantity){
        shoppingCartMap.addItem(productId, quantity);
    }
    
    /*
    it displays the total products in shopping cart
    */
    @RequestMapping(value="/user/shoppingCart")
    public ModelAndView shoppingCart() throws SQLException, ClassNotFoundException{
        ModelAndView userModel = new ModelAndView("/user/shoppingCart");  
        ModelAndView adminModel = new ModelAndView("redirect:/user/shoppingCart");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            user = new User();
            user.setSessionValue(username); //setting the session value in User entity
            fetchSessionData = new User();
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if (fetchSessionData.getRoleId() == 1) {
                return adminModel;
            } else {
                //gets all the product list in shopping cart
                List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries = shoppingCartHandlerService.getShoppingCartEntries(shoppingCartMap);                
                userModel.addObject("shoppingCartHandlerEntries", shoppingCartHandlerEntries);
                
                //grand total of the shopping cart
                userModel.addObject("grandTotal", shoppingCartHandlerService.getTotalPrice(shoppingCartHandlerEntries));
                
                //total quantity of products in shopping cart
                userModel.addObject("shoppingItemSize", shoppingCartMap.getItemSize());
                
                //total calorie value of the shopping cart
                userModel.addObject("totalCalorieValue", shoppingCartHandlerService.getTotalCalorie(shoppingCartHandlerEntries));

                return userModel;
            }
        }
        return new ModelAndView("redirect:/login");
        
    }   
    
    /*
    shopping cart order
    */
    @RequestMapping(value="/user/shoppingCartOrder")
    public ModelAndView order(final RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException{
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
                //fetching shopping cart products
                List<ShoppingCartHandlerEntry> shoppingCartHandlerEntries = shoppingCartHandlerService.getShoppingCartEntries(shoppingCartMap);

                //creating random cart Id
                java.util.UUID randomUUID = java.util.UUID.randomUUID();
                shoppingCart = new ShoppingCart();
                shoppingCart.setCartId(randomUUID.toString());
                shoppingCart.setUsername(username);
                Date utilEnrollDate = new Date();
                java.sql.Date sqlEnrollDate = new java.sql.Date(utilEnrollDate.getTime());
                shoppingCart.setPurchasedDate(sqlEnrollDate);
                
                /*
                firstly, it registers shopping cart of the user
                and then, adds the products in that shopping cart id                
                */                                
                orderService.registerUserShoppingCart(shoppingCart);
                orderService.registerUserShoppingCartItem(shoppingCart,shoppingCartHandlerEntries);
                redirectAttributes.addFlashAttribute("orderMessage", "Congratulation! Your order will be forwarded as soon as you confirm your order confirmation.");
                shoppingCartMap.clearHashmap(); //clearing hash map
                return model;
            }                       
        }
        return new ModelAndView("redirect:/login");
    }
    
    /*
    get order history
    */
    @RequestMapping("/user/orderHistory")
    public ModelAndView orderHistory() throws SQLException, ClassNotFoundException{
        ModelAndView userModel = new ModelAndView("/user/orderHistory");
        ModelAndView adminModel = new ModelAndView("redirect:/admin/home");
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            user = new User();
            user.setSessionValue(username); //setting the session value in User entity
            fetchSessionData = new User();
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if(fetchSessionData.getRoleId()==1){                
                return adminModel;
            }else{
                List<ShoppingCartHandlerEntry> s = orderService.getUserShoppingCarts(username);
                userModel.addObject("s", s);
                return userModel;
            }
        }
        return new ModelAndView("redirect:/login");
        
    }
    
}
