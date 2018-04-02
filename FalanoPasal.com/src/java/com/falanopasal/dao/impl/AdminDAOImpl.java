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
                                product.getDescription(),0});
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
        product.setProductId(rs.getInt("productId"));
        product.setProductName(rs.getString("productName"));
        product.setProductPrice(rs.getFloat("price"));
        product.setCalorieValue(rs.getFloat("calorieValue"));
        product.setDescription(rs.getString("description"));
        product.setStockValue(rs.getInt("stockAmount"));
        product.setCategoryId(rs.getInt("categoryId"));
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

    @Override
    public void insertCategory(Category category) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.admin.INSERT_CATEGORY, new Object[]{category.getCategoryName()});        
    }

    @Override
    public Product getProductById(int productId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.queryForObject(SQLConstant.admin.GET_PRODUCT_BY_ID, new Object[]{productId}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductData(rs);
            }
        });
    }

    @Override
    public void editProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.admin.EDIT_PRODUCT,
                new Object[]{product.getProductName(),
                            product.getProductPrice(),
                            product.getCalorieValue(),
                            product.getDescription(),
                            product.getProductId()});
    }

    @Override
    public void updateProductStock(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.admin.UPDATE_PRODUCT_STOCK, new Object[]{product.getUpdatedStockValue(),product.getProductId()});
    }

    @Override
    public void updateProductCategoryType(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.admin.UPDATE_PRODUCT_CATEGORY_TYPE, new Object[]{product.getCategoryId(),product.getProductId()});
    }

    @Override
    public void deleteProduct(int productId) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.admin.DELETE_PRODUCT, new Object[]{productId});
    }

    @Override
    public List<Category> getCategoryById(int categoryId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.admin.GET_ALL_CATEGORY_COLUMN_BY_ID, new Object[]{categoryId},new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return mapCategoryData(rs);
            }
        });
    }

    
}
