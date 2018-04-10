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
import com.falanopasal.entity.User;
import com.falanopasal.service.CategoryService;
import com.falanopasal.service.OrderService;
import com.falanopasal.service.ProductService;
import com.falanopasal.service.SessionService;
import com.falanopasal.service.UserService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;
    
    @Autowired 
    private OrderService orderService;
    
    private SessionManager sessionManager; //to manage session
    
    private Path path; // to upload image
    
    /*
    it opens admin home page
    */
    @RequestMapping("/admin/home")
    public ModelAndView adminHomePage(ModelMap mm) throws SQLException,ClassNotFoundException{
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
                mm.addAttribute("username",sessionManager.getAttr("username").toString());
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
    /*
    it opens category page
    it shows category lists
    */
    @RequestMapping(value="/admin/category")
    public ModelAndView adminCategory() throws SQLException, ClassNotFoundException{
        ModelAndView adminModel =  new ModelAndView("/admin/category");
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
                List<Category> categoryList = categoryService.getCategory();
                adminModel.addObject("categoryList", categoryList);
                adminModel.addObject("category", new Category());
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
    /*
    it adds category
    */
    @RequestMapping(value="/admin/addCategory", method=RequestMethod.POST)
    public ModelAndView adminCategoryInsert(@ModelAttribute("category") Category category) throws SQLException, ClassNotFoundException{
        categoryService.insertCategory(category);
        return new ModelAndView("redirect:/admin/category");
    }    
    
    /*
    it opens product page
    it shows product lists
    */
    @RequestMapping(value="/admin/product")
    public ModelAndView adminProductPage() throws SQLException, ClassNotFoundException{
        ModelAndView adminModel = new ModelAndView("/admin/product");
        ModelAndView userModel = new ModelAndView("redirect:/user/home");        
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            User user = new User();
            user.setSessionValue(username);
            User fetchSessionData;
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if (fetchSessionData.getRoleId() == 2) {
                return userModel;
            } else {
                List<Category> categoryList = categoryService.getCategory();
                List<Product> productList = productService.getProduct();
                adminModel.addObject("categoryList", categoryList);
                adminModel.addObject("productList", productList);
                adminModel.addObject("product", new Product());

                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");        
    }
    
    /*
    it displays the product list by category id
    */
    @RequestMapping(value="/admin/product-by-category-{categoryId}")
    public ModelAndView adminProductPageByCategory(@PathVariable("categoryId") int categoryId) throws SQLException, ClassNotFoundException{
        ModelAndView adminModel = new ModelAndView("/admin/product");
        ModelAndView userModel = new ModelAndView("redirect:/user/home");        
        sessionManager = new SessionManager();
        if(sessionManager.getAttr("username")!=null){
            String username = sessionManager.getAttr("username").toString();
            User user = new User();
            user.setSessionValue(username);
            User fetchSessionData;
            fetchSessionData = sessionService.getDataFromSessionValue(user);
            if (fetchSessionData.getRoleId() == 2) {
                return userModel;
            } else {
                List<Category> categoryList = categoryService.getCategory();
                List<Product> productList = productService.getProductByCategoryId(categoryId);
                adminModel.addObject("categoryList", categoryList);
                adminModel.addObject("productList", productList);
                adminModel.addObject("product", new Product());

                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");        
    }
    
    /*
    it saves product data
    */
    @RequestMapping(value="/admin/addProduct",method=RequestMethod.POST)
    public ModelAndView adminProductInsert(@ModelAttribute("product") Product product) throws SQLException,ClassNotFoundException,ParseException{
        productService.insertProduct(product);
        return new ModelAndView("redirect:/admin/product");
    }
    
    /*
    edit product details 
    */
    @RequestMapping(value="/admin/productEdit/{productId}")
    public ModelAndView adminProductEdit(@PathVariable("productId") int productId) throws SQLException, ClassNotFoundException{
        ModelAndView adminModel = new ModelAndView("/admin/productEdit");
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
            } else {
                adminModel.addObject("product", new Product());
                Product product = productService.getProductByProductId(productId);
                List<Category> categoryList = categoryService.getCategory();
                adminModel.addObject("categoryList", categoryList);
                adminModel.addObject(product);
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");
        
    }
    
    /*
    it updates the product details excluding stock value and category type
    */
    @RequestMapping(value="/admin/productEditSave", method=RequestMethod.POST)
    public ModelAndView adminProductEditSave(@ModelAttribute("product") Product product) throws SQLException,ClassNotFoundException, ParseException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        productService.editProduct(product);        
        return model;
    }
    
    /*
    it updates the product stock value
    and also updates the total product bought by the pasal
    */
    @RequestMapping(value="/admin/productStockEditSave", method=RequestMethod.POST)
    public ModelAndView adminProductStockEditSave(@ModelAttribute("product") Product product) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        productService.updateProductStock(product);
        productService.updateProductBought(product);
        return model;
    }
 
    /*
    it updates product category id
    */
    @RequestMapping(value="/admin/productCategoryIdEditSave",method=RequestMethod.POST)
    public ModelAndView adminProductCategoryIdEditSave(@ModelAttribute("product") Product product) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        productService.updateProductCategoryId(product);
        return model;
    }
    
    /*
    it deletes product
    */
    @RequestMapping(value="/admin/productDelete/{productId}")
    public ModelAndView adminProductDelete(@PathVariable("productId") int productId,final RedirectAttributes redirectAttributes) throws SQLException,ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        Product product = productService.getProductByProductId(productId);
        if(product!=null){
            if(product.getStockValue()==0){
                productService.deleteProduct(productId);
                return model;
            }
            redirectAttributes.addFlashAttribute("message", "Stock value must be 0!");
            return model;
            
        }
        return model;
    }

    /*
    it opens product image list
    */
    @RequestMapping(value="/admin/productImage")
    public ModelAndView productImagePage() throws SQLException, ClassNotFoundException{
        ModelAndView adminModel = new ModelAndView("/admin/productImage");
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
                List<Category> categoryList = categoryService.getCategory();
                List<Product> productList = productService.getProduct();
                adminModel.addObject("categoryList", categoryList);
                adminModel.addObject("productList", productList);
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");        
    }
    
    /*
    it shows the product image by category
    */
    @RequestMapping(value="/admin/productImageByCategory/{categoryId}")
    public ModelAndView productImageByCategory(@PathVariable("categoryId") int categoryId) throws SQLException, ClassNotFoundException{
        ModelAndView adminModel = new ModelAndView("/admin/productImageByCategory");
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
                List<Category> categoryList = categoryService.getCategoryById(categoryId);
                List<Product> productList = productService.getProductByCategoryId(categoryId);
                adminModel.addObject("categoryList",categoryList);
                adminModel.addObject("productList", productList);  
                adminModel.addObject("product", new Product()); //form model attribute
                
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");
        
    }
    
    /*
    it uploads the products photo
    */
    @RequestMapping(value="/admin/checkUpload", method=RequestMethod.POST)
    public ModelAndView uploadImage(@ModelAttribute("product") Product product){
        ModelAndView model = new ModelAndView("redirect:/admin/productImage");
        MultipartFile productImage = product.getProductImage();
        path = Paths.get("C:/Users/bipin/Documents/NetBeansProjects/FalanoPasal.com/FalanoPasal.com/web/WEB-INF/assets/images/"+product.getCategoryId()+product.getProductId()+".png");        
        if(productImage!=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(IllegalStateException | IOException e){
                e.printStackTrace();
                throw new RuntimeException("Saving User image was not successful", e);
            }
        }
        return model;
    }
    
    /*
    it deletes the products photo
    */
    @RequestMapping(value="/deletePhoto")
    public ModelAndView deletePhoto(@RequestParam("categoryId") int categoryId,@RequestParam("productId") int productId){       
        ModelAndView model = new ModelAndView("redirect:/admin/productImage");
        path = Paths.get("C:/Users/bipin/Documents/NetBeansProjects/FalanoPasal.com/FalanoPasal.com/web/WEB-INF/assets/images/"+categoryId+productId+".png");        
        if(Files.exists(path)){
            try{
               Files.delete(path);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return model;
    }
    
    /*
    it displays the total number of customer 
    */
    @RequestMapping("/admin/customer")
    public ModelAndView adminCustomerList() throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/customer");
        List<User> userList = userService.getAllCustomer();
        model.addObject("userList", userList);
        return model;
    }
    
    /*
    display order list
    */
    @RequestMapping("/admin/order")
    public ModelAndView adminOrderList() throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/order");
        List<ShoppingCart> shoppingCartList = orderService.getAllShoppingCart();
        model.addObject("shoppingCartList", shoppingCartList);
        return model;
    }
    
    @RequestMapping("/admin/orderItem/{cartId}")
    public ModelAndView adminOrderItemList(@RequestParam("cartId") String cartId) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/orderItem");
        List<ShoppingCartHandlerEntry> ShoppingCartItemList = orderService.getAllShoppingCartItemByCartId(cartId);
        model.addObject("ShoppingCartItemList", ShoppingCartItemList);
        return model;
    }
}

