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
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private AdminService adminService;
    
    private SessionManager sessionManager;
    
    private Path path;
    
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
//                List<Product> productList = adminService.getProductByCategoryId(2);
//                adminModel.addObject("productList", productList);
                return adminModel;
            }
        }
        return new ModelAndView("redirect:/login");
    }
    
    @RequestMapping(value="home", params = "searchTerm")
    public ModelAndView adminHomePage2(@RequestParam("searchTerm") String searchTerm) throws SQLException, ClassNotFoundException{
        List<Product> productList = adminService.getProductByCategoryId(Integer.parseInt(searchTerm));
        ModelAndView model = new ModelAndView("redirect:/admin/home");
        model.addObject("productList", productList);
        return model;
    }
    
	@RequestMapping(value = "/products-by-category-{categoryName}")
	public ModelAndView listProductsByCategory(@PathVariable("categoryName") String categoryName) {
//		List<Product> products = productService.findProductsByCategory(categoryName);
//		List<String> categories = categoryService.findAll();
//		
//		ModelAndView model = new ModelAndView("products");
//		
//		model.addObject("categoryList", categories);
//		model.addObject("productList", products);
//		
		return null;
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
    
    @RequestMapping(value="/admin/category")
    public ModelAndView adminCategory() throws SQLException, ClassNotFoundException{
        ModelAndView model =  new ModelAndView("/admin/category");
        List<Category> categoryList = adminService.getCategory();
        model.addObject("categoryList", categoryList);
        model.addObject("category", new Category());
        return model;
    }
    
    @RequestMapping(value="/admin/addCategory", method=RequestMethod.POST)
    public ModelAndView adminCategoryInsert(@ModelAttribute("category") Category category) throws SQLException, ClassNotFoundException{
        adminService.insertCategory(category);
        return new ModelAndView("redirect:/admin/category");
    }    
    
    @RequestMapping(value="/admin/productEdit/{productId}")
    public ModelAndView adminProductEdit(@PathVariable("productId") int productId) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/productEdit");
        model.addObject("product", new Product()); 
        Product product = adminService.getProductById(productId);
        List<Category> categoryList = adminService.getCategory();
        model.addObject("categoryList", categoryList);
        model.addObject(product);
        return model;
    }
    
    @RequestMapping(value="/admin/productEditSave", method=RequestMethod.POST)
    public ModelAndView adminProductEditSave(@ModelAttribute("product") Product product) throws SQLException,ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        adminService.editProduct(product);
        return model;
    }
    
    @RequestMapping(value="/admin/productStockEditSave", method=RequestMethod.POST)
    public ModelAndView adminProductStockEditSave(@ModelAttribute("product") Product product) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        adminService.updateProductStock(product);
        return model;
    }
    
    @RequestMapping(value="/admin/productCategoryTypeEditSave",method=RequestMethod.POST)
    public ModelAndView adminProductCategoryTypeEditSave(@ModelAttribute("product") Product product) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        adminService.updateProductCategoryType(product);
        return model;
    }
    
    @RequestMapping(value="/admin/productDelete/{productId}")
    public ModelAndView adminProductDelete(@PathVariable("productId") int productId,final RedirectAttributes redirectAttributes) throws SQLException,ClassNotFoundException{
        ModelAndView model = new ModelAndView("redirect:/admin/product");
        Product product = adminService.getProductById(productId);
        if(product!=null){
            if(product.getStockValue()==0){
                adminService.deleteProduct(productId);
                return model;
            }
            redirectAttributes.addFlashAttribute("message", "Stock value must be 0!");
            return model;
            
        }
        return model;
    }
    
    @RequestMapping(value="/admin/productImage")
    public ModelAndView productImagePage() throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/productImage");
        List<Category> categoryList = adminService.getCategory();
        List<Product> productList = adminService.getProduct();
        model.addObject("categoryList", categoryList);
        model.addObject("productList", productList);
        return model;
    }
    
    @RequestMapping(value="/admin/productImageByCategory/{categoryId}")
    public ModelAndView productImageByCategory(@PathVariable("categoryId") int categoryId) throws SQLException, ClassNotFoundException{
        ModelAndView model = new ModelAndView("/admin/productImageByCategory");
        List<Category> categoryList = adminService.getCategoryById(categoryId);
        List<Product> productList = adminService.getProductByCategoryId(categoryId);
        model.addObject("categoryList",categoryList);
        model.addObject("productList", productList);  
        model.addObject("product", new Product()); //form model attribute
        return model;
    }
            
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
    
}

