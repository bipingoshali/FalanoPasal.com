/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.Package;
import com.falanopasal.entity.PackageMap;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface PackageHandlerDAO {
    List<Package> getMappedPackageProduct(PackageMap packageMap) throws SQLException,ClassNotFoundException;
    float getOldTotalPrice(List<Package> packageItemList);
    float getNewTotalPrice(List<Package> packageItemList);  
    void insertPackage(Package pack) throws SQLException,ClassNotFoundException;
    void insertPackageItem(Package pack,List<Package> packageItemList) throws SQLException,ClassNotFoundException;
    List<Package> getAllPackage() throws SQLException,ClassNotFoundException;
    List<Package> getPackageById(String packageId) throws SQLException,ClassNotFoundException;
    void insertUserPackage(Package pack) throws SQLException,SQLException;
    List<Package> getUserBoughtPackage(String username) throws SQLException,ClassNotFoundException;
    List<Package> getAllBoughtPackage() throws SQLException,ClassNotFoundException;
}
