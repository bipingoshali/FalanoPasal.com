/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service;

import com.falanopasal.entity.PackageMap;
import com.falanopasal.entity.Package;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface PackageService {
        List<Package> getMappedPackageProduct(PackageMap packageMap) throws SQLException,ClassNotFoundException;

}
