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
    Map<Integer,Integer> packageProducts;
    
    public PackageMap(){
        productCount=0;
        packageProducts = new HashMap<>();
    }

    public void addPackageProduct(int productId,int newprice){
        if(!packageProducts.containsKey(productId)){
            packageProducts.put(productId, newprice); //product id and its quantity is register in here
        }else{
            packageProducts.put(productId, newprice); //works when quantity is added agian in the same product Id
        }
        productCount+=1;           
    }
    
    public Map<Integer, Integer> getPackageProduct(){
        return packageProducts;
    }
    
    public int getProductInPackage(int productId){
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
