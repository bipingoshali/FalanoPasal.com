/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import com.falanopasal.entity.Category;
import com.falanopasal.entity.Delivery;
import com.falanopasal.entity.Product;
import com.falanopasal.entity.ShoppingCart;
import com.falanopasal.entity.ShoppingCartHandlerEntry;
import com.falanopasal.entity.ShoppingCartMap;
import com.falanopasal.entity.User;
import com.falanopasal.service.CategoryService;
import com.falanopasal.service.DeliveryService;
import com.falanopasal.service.OrderService;
import com.falanopasal.service.ProductService;
import com.falanopasal.service.SessionService;
import com.falanopasal.service.ShoppingCartHandlerService;
import com.falanopasal.service.UserService;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private DeliveryService deliveryService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ApplicationContext appContext;
    
    private SessionManager sessionManager; //session values
    private User user; //to set session values (username)
    private User fetchSessionData; //fetch user values
    private ShoppingCart shoppingCart; //to register shopping cart
    private Product product; //to know which user has rate a product
    private Product usernameProductComment; // current user comment is shown
    
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
                product = new Product();
                product = productService.getProductByProductId(productId);
                List<Product> productComment = productService.getAllProductCommentByProductId(productId);
                if(product.getStockValue()==0){
                    userModel.addObject("message", "Out of stock");
                }
                userModel.addObject("productComment", productComment);
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
    public @ResponseBody String addToCart(@RequestParam(value="productId") int productId,@RequestParam(value="quantity") int quantity) throws SQLException, ClassNotFoundException{
        Product product = productService.getProductByProductId(productId);
        if(quantity>product.getStockValue()){
            return "Not enough stock";            
        }
        shoppingCartMap.addItem(productId, quantity);
        return null;
    }
    
    @RequestMapping(value="/user/clearCart")
    public @ResponseBody void clearCart(){
        shoppingCartMap.clearHashmap();
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
                
                userModel.addObject("delivery", new Delivery());
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
    @RequestMapping(value="/user/shoppingCartOrder", method=RequestMethod.POST)
    public ModelAndView order(@ModelAttribute("delivery") Delivery delivery,final RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException, ParseException{
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
                delivery.setCartId(randomUUID.toString());                
                shoppingCart.setPaymentMethod(delivery.getPayment());
                shoppingCart.setCartId(randomUUID.toString());
                shoppingCart.setUsername(username);
                shoppingCart.setGrandTotal(shoppingCartHandlerService.getTotalPrice(shoppingCartHandlerEntries));
                Date utilEnrollDate = new Date();
                java.sql.Date sqlEnrollDate = new java.sql.Date(utilEnrollDate.getTime());
                shoppingCart.setPurchasedDate(sqlEnrollDate);
                
                /*
                checking the debit amount of the customer
                */
                if(delivery.getPayment().equals("Debit")){
                    user = new User();
                    user.setUsername(username); //setting username in userService.getByUsername

                    fetchSessionData = new User();
                    fetchSessionData = userService.getByUsername(user); //fetch value of the provided username
                    String userEmail = fetchSessionData.getEmail(); //fetch email which will be used for sending email if the customer wants to buy the products in credit
                    if(shoppingCartHandlerService.getTotalPrice(shoppingCartHandlerEntries)>fetchSessionData.getDebitAmount()){
                        redirectAttributes.addFlashAttribute("orderMessage", "Sorry! You do not have enough debit amount.");
                        return model;                    
                    }else{
                        /*
                        if the debit amount is enough to finish the transaction
                        it will update the debit amount of the customer
                        */
                        fetchSessionData=new User(); 
                        fetchSessionData.setUsername(username);
                        fetchSessionData.setDebitAmount(shoppingCartHandlerService.getTotalPrice(shoppingCartHandlerEntries)); //setting the grand total of the shopping cart
                        fetchSessionData.setEmail(userEmail);
                        userService.updateDebitAmount(fetchSessionData);
                    }                    
                }
                
                /*
                At first, it registers shopping cart of the user
                and then, adds the products in that shopping cart id                
                */
                orderService.registerUserShoppingCart(shoppingCart);
                orderService.registerUserShoppingCartItem(shoppingCart,shoppingCartHandlerEntries);
                /*
                it decrease the product stock amount
                */
                orderService.minusProductStock(shoppingCartHandlerEntries);
                deliveryService.insert(delivery);
                redirectAttributes.addFlashAttribute("orderMessage", "Congratulation! Your order will be forwarded as soon as you confirm your order confirmation.");
                
                /*
                send order confirmation email
                */
                String msg = "Congratulation "+sessionManager.getAttr("username").toString()+"! You have ordered following list of item from FalanoPasal.com \n";
                for(int i=0;i<shoppingCartHandlerEntries.size();i++){
                    msg+= "Product name: "+shoppingCartHandlerEntries.get(i).getProductName()+
                            " | Price: "+shoppingCartHandlerEntries.get(i).getPrice()+
                            " | Quantity: "+shoppingCartHandlerEntries.get(i).getQuantity()+
                            " | Total Price: "+shoppingCartHandlerEntries.get(i).getProductTotalPrice()+" \n";                    
                }
                msg+= "Grand Total: "+shoppingCartHandlerService.getTotalPrice(shoppingCartHandlerEntries)+" \n";
                msg+= "Payment method: "+delivery.getPayment()+" \n";
                if(delivery.getDeliveryType().equals("custom")){
                    msg+="Delivery type: "+delivery.getDeliveryType()+" \n";
                    msg+="Date: "+delivery.getCustomDate()+" \n";
                    msg+="Time: "+delivery.getCustomTime()+" \n";
                }else{
                    msg+="Delivery type: "+delivery.getDeliveryType()+" \n";                    
                }
                msg+= "Please click the link below to verify your order. \n";
                msg+= "http://localhost:8080/FalanoPasal.com/confirmOrder?token="+randomUUID.toString()+"&username="+sessionManager.getAttr("username").toString();
                Mail sMail = (Mail) appContext.getBean("mail");
//                sMail.sendMail("bipingoshali2527@gmail.com", fetchSessionData.getEmail(), "FalanoPasal.com", msg);
                shoppingCartMap.clearHashmap(); //clearing hash map
                return model;
            }                       
        }
        return new ModelAndView("redirect:/login");
    }
    
    /*
    it updates the user order status
    */
    @RequestMapping(value="/confirmOrder")
    public ModelAndView confirmOrder(@RequestParam("token") String token,@RequestParam("username") String username) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/user/home");
        sessionManager = new SessionManager();
        user = new User();
        user.setCartId(token);
        user.setUsername(username);
        //assigning session value
        sessionManager.setData(new String[]{"username"}, new String[]{username});
        orderService.updateOrderStatus(user);
        return model;
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
    
    /*
    rate product 
    if user have already rate for a product
    then, the user rate will be updated of that product
    */
    @RequestMapping("/user/productDetail/rateProduct")
    public @ResponseBody void rateProduct(@RequestParam("productId") int productId,@RequestParam("rating") int rating) throws SQLException, ClassNotFoundException{
        sessionManager = new SessionManager();        
        product = new Product();        
        product.setProductId(productId);
        product.setProductRating(rating);
        product.setUsername(sessionManager.getAttr("username").toString());
        if(productService.checkUserRate(product)){
            productService.updateUserRateForAProduct(product);
            return;
        }
        productService.rateProduct(product);
    }
    
    /*
    comment product    
    */
    @RequestMapping("/user/productDetail/commentProduct")
    public @ResponseBody void commentProduct(@RequestParam("productId") int productId,@RequestParam("comment") String comment) throws SQLException, ClassNotFoundException{
        sessionManager = new SessionManager();
        product = new Product();
        product.setProductId(productId);
        product.setProductComment(comment);
        product.setUsername(sessionManager.getAttr("username").toString());        
        productService.commentProduct(product);            
    }
    
    /*
    subscribe product
    */
    @RequestMapping("/user/productDetail/subscribeproduct")
    public @ResponseBody void subscribeProduct(@RequestParam("productId") int productId,@RequestParam("quantity") int quantity,@RequestParam("duration") String duration) throws SQLException, ClassNotFoundException{
        sessionManager = new SessionManager();
        product = new Product();
        product.setProductId(productId);
        product.setSubscribeProductQuantity(quantity);
        product.setUsername(sessionManager.getAttr("username").toString());
        product.setProductSubscriptionDuration(duration);
        Date utilEnrollDate = new Date();
        java.sql.Date sqlEnrollDate = new java.sql.Date(utilEnrollDate.getTime()); 
        product.setProductSubscribeDate(sqlEnrollDate);
        productService.subscribeProduct(product);
    }
        
}
