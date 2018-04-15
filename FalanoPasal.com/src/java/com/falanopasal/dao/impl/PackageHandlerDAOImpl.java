/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.dao.PackageHandlerDAO;
import com.falanopasal.entity.PackageMap;
import com.falanopasal.entity.Package;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class PackageHandlerDAOImpl implements PackageHandlerDAO{

    @Override
    public List<Package> getMappedPackageProduct(PackageMap packageMap) throws SQLException, ClassNotFoundException {
        List<Package> p = new ArrayList<>();
        
        for(int productId:packageMap.getPackageProduct().keySet()){
            Package s = new Package();
            
            int newprice = packageMap.getProductInPackage(productId);
            
            s.setProductId(productId);
            s.setNewPrice(newprice);
            
            p.add(s);
        }
        return p;
        
    }

    
}
