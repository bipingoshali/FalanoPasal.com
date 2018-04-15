/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.PackageHandlerDAO;
import com.falanopasal.entity.Package;
import com.falanopasal.entity.PackageMap;
import com.falanopasal.service.PackageService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class PackageServiceImpl implements PackageService{
    
    @Autowired
    private PackageHandlerDAO packageDao;

    @Override
    public List<Package> getMappedPackageProduct(PackageMap packageMap) throws SQLException, ClassNotFoundException {
        return packageDao.getMappedPackageProduct(packageMap);
    }
    
}
