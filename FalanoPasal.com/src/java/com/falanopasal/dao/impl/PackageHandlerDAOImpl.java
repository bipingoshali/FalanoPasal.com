/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.PackageHandlerDAO;
import com.falanopasal.entity.PackageMap;
import com.falanopasal.entity.Package;
import com.falanopasal.entity.Product;
import com.falanopasal.service.ProductService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class PackageHandlerDAOImpl implements PackageHandlerDAO{

    @Autowired
    private ProductService productService;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Package> getMappedPackageProduct(PackageMap packageMap) throws SQLException, ClassNotFoundException {
        List<Package> p = new ArrayList<>();
        
        for(int productId:packageMap.getPackageProduct().keySet()){
            Product product = productService.getProductByProductId(productId);
            Package s = new Package();
            
            float newprice = packageMap.getProductFromPackage(productId);
            
            s.setProductId(productId);
            s.setProductName(product.getProductName());
            s.setOldPrice(product.getProductPrice());
            s.setNewPrice(newprice);
            
            p.add(s);
        }
        return p;
        
    }

    @Override
    public void insertPackage(Package pack) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Package.PACKAGE_INSERT, 
                new Object[]{pack.getPackageId(),
                    pack.getPackageName(),
                    pack.getGrandTotalOld(),
                    pack.getGrandTotalNew()});
    }

    @Override
    public void insertPackageItem(Package pack, List<Package> packageItemList) throws SQLException, ClassNotFoundException {
        for(int i=0;i<packageItemList.size();i++){
            jdbcTemplate.update(SQLConstant.Package.PACKAGE_ITEM_INSERT, 
                    new Object[]{pack.getPackageId(),
                    packageItemList.get(i).getProductId(),
                    packageItemList.get(i).getOldPrice(),
                    packageItemList.get(i).getNewPrice()});
        }
    }

    @Override
    public float getOldTotalPrice(List<Package> packageItemList) {
        float total = 0;
        for(Package s : packageItemList) {
            total += s.getOldPrice();
        }
        return total;        
    }

    @Override
    public float getNewTotalPrice(List<Package> packageItemList) {
        float total = 0;
        for(Package s : packageItemList) {
            total += s.getNewPrice();
        }
        return total;        
    }

    @Override
    public List<Package> getAllPackage() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Package.GET_ALL_PACKAGE, new RowMapper<Package>() {
            @Override
            public Package mapRow(ResultSet rs, int i) throws SQLException {
                return mapPackageData(rs);
            }
        });
    }
    
    private Package mapPackageData(ResultSet rs) throws SQLException{
        Package pack = new Package();
        pack.setPackageId(rs.getString("packageid"));
        pack.setPackageName(rs.getString("packagename"));
        pack.setGrandTotalOld(rs.getFloat("grandTotalOld"));
        pack.setGrandTotalNew(rs.getFloat("grandTotalNew"));
        return pack;
    }

    @Override
    public List<Package> getPackageById(String packageId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Package.GET_PACKAGE_BY_ID, new Object[]{packageId}, new RowMapper<Package>() {
            @Override
            public Package mapRow(ResultSet rs, int i) throws SQLException {
                return mapPackageItemData(rs);
            }
        });
    }
    
    private Package mapPackageItemData(ResultSet rs)throws SQLException{
        Package pack = new Package();
        pack.setPackageName(this.getProductName(rs.getInt("productId")));
        pack.setOldPrice(rs.getFloat("oldPrice"));
        pack.setNewPrice(rs.getFloat("newPrice"));
        return pack;
    }
    
    private String getProductName(int productId){
        String productName="";
        productName = jdbcTemplate.queryForObject(SQLConstant.Product.GET_PRODUCT_NAME_BY_ID, new Object[]{productId}, String.class);
        return productName;
    }    

    @Override
    public void insertUserPackage(Package pack) throws SQLException, SQLException {
        jdbcTemplate.update(SQLConstant.PackageBought.INSERT_PACKAGE_BOUGHT,
                new Object[]{pack.getUsername(),pack.getPackageId(),pack.getPackageBoughtDate()});
    }
    

    
}
