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
import java.util.Date;
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

    @Override
    public void insertPackage(Package pack) throws SQLException, ClassNotFoundException {
        packageDao.insertPackage(pack);
    }

    @Override
    public void insertPackageItem(Package pack, List<Package> packageItemList) throws SQLException, ClassNotFoundException {
        packageDao.insertPackageItem(pack, packageItemList);
    }

    @Override
    public float getOldTotalPrice(List<Package> packageItemList) {
        return packageDao.getOldTotalPrice(packageItemList);
    }

    @Override
    public float getNewTotalPrice(List<Package> packageItemList) {
        return packageDao.getNewTotalPrice(packageItemList);
    }

    @Override
    public List<Package> getAllPackage() throws SQLException, ClassNotFoundException {
        return packageDao.getAllPackage();
    }

    @Override
    public List<Package> getPackageById(String packageId) throws SQLException, ClassNotFoundException {
        return packageDao.getPackageById(packageId);
    }

    @Override
    public void insertUserPackage(Package pack) throws SQLException, SQLException {
        //setting the default system date in user enroll date
        Date utilBoughtDate = new Date();
        java.sql.Date sqlBoughtDate = new java.sql.Date(utilBoughtDate.getTime());
        pack.setPackageBoughtDate(sqlBoughtDate);
        
        packageDao.insertUserPackage(pack);
    }

    @Override
    public List<Package> getUserBoughtPackage(String username) throws SQLException, ClassNotFoundException {
        return packageDao.getUserBoughtPackage(username);
    }

    @Override
    public List<Package> getAllBoughtPackage() throws SQLException, ClassNotFoundException {
        return packageDao.getAllBoughtPackage();
    }
    
}
