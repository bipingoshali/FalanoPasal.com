/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.AdminDAO;
import com.falanopasal.entity.Category;
import com.falanopasal.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class AdminDAOImpl implements AdminDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategory() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.admin.GET_CATEGORY, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return mapCategoryData(rs);
            }
        });
    }
    
    private Category mapCategoryData(ResultSet rs) throws SQLException{
        Category category = new Category();
        category.setCategoryId(rs.getInt("categoryId"));
        category.setCategoryName(rs.getString("categoryName"));
        return category;
    }

    @Override
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.admin.INSERT_PRODUCT, 
                new Object[]{product.getCategoryId(),
                                product.getProductName(),
                                product.getProductPrice(),
                                product.getCalorieValue(),
                                product.getDescription()});
    }

    @Override
    public List<Product> getProduct() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.admin.GET_PRODUCT, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductData(rs);
            }
        });
    }
    
    private Category getCategoryName(int categoryId){
        String categoryName="";
        categoryName = jdbcTemplate.queryForObject(SQLConstant.admin.GET_CATEGORY_BY_ID, new Object[]{categoryId}, String.class);
        return new Category(categoryId, categoryName);
    }
    
    private Product mapProductData(ResultSet rs) throws SQLException{
        Product product = new Product();
        product.setCategoryId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
//        product.setProductPrice(rs.getFloat("price"));
//        product.setCalorieValue(rs.getFloat("calorieValue"));
        product.setDescription(rs.getString("description"));
        product.setStockValue(rs.getInt("stockAmount"));
        product.setCategory(this.getCategoryName(rs.getInt("categoryId")));
        return product;
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.admin.GET_PRODUCT_BY_CATEGORYID, new Object[]{categoryId}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductData(rs);
            }
        });
    }

    
}
