/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.entity;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author bipin
 */
@Component
public class PackageMap {
    int productCount;
    Map<Integer,Float> packageProducts;
    
    public PackageMap(){
        productCount=0;
        packageProducts = new HashMap<>();
    }

    public void addPackageProduct(int productId,float newprice){
        if(!packageProducts.containsKey(productId)){
            packageProducts.put(productId, newprice); //product id and its quantity is register in here
        }else{
            packageProducts.put(productId, newprice); //works when new price is assigned agian in the same product Id
        }
        productCount+=1;           
    }
    
    public Map<Integer, Float> getPackageProduct(){
        return packageProducts;
    }
    
    public Float getProductFromPackage(int productId){
        return packageProducts.get(productId);
    }
    
    public int getTotalProductInPackage(){
        return productCount;
    }
    
    public void clearPackageProduct(){
        productCount=0;
        packageProducts.clear();
    }
    
    
}
