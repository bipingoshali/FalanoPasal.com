/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.ProductDAO;
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
public class ProductDAOImpl implements ProductDAO{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProduct() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Product.GET_PRODUCT, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductData(rs);
            }
        });
    }
    
    private Category getCategoryName(int categoryId){
        String categoryName="";
        categoryName = jdbcTemplate.queryForObject(SQLConstant.Category.GET_CATEGORY_NAME_BY_ID, new Object[]{categoryId}, String.class);
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
    public Product getProductByProductId(int productId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.queryForObject(SQLConstant.Product.GET_PRODUCT_BY_ID, new Object[]{productId}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductData(rs);
            }
        });        
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Product.GET_PRODUCT_BY_CATEGORYID, new Object[]{categoryId}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductData(rs);
            }
        });        
    }

    @Override
    public void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Product.INSERT_PRODUCT, 
                new Object[]{product.getCategoryId(),
                                product.getProductName(),
                                product.getProductPrice(),
                                product.getCalorieValue(),
                                product.getDescription(),0});        
    }

    @Override
    public void editProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Product.EDIT_PRODUCT,
                new Object[]{product.getProductName(),
                            product.getProductPrice(),
                            product.getCalorieValue(),
                            product.getDescription(),
                            product.getProductId()});
    }

    @Override
    public void updateProductStock(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Product.UPDATE_PRODUCT_STOCK, new Object[]{product.getUpdatedStockValue(),product.getProductId()});
    }

    @Override
    public void updateProductCategoryId(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Product.UPDATE_PRODUCT_CATEGORY_TYPE, new Object[]{product.getCategoryId(),product.getProductId()});
    }

    @Override
    public void deleteProduct(int productId) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Product.DELETE_PRODUCT, new Object[]{productId});
    }

    @Override
    public void rateProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.ProductRatingCommenting.RATE_PRODUCT, new Object[]{product.getUsername(),product.getProductId(),product.getProductRating()});
    }

    @Override
    public void commentProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.ProductRatingCommenting.COMMENT_PRODUCT, new Object[]{product.getUsername(),product.getProductId(),product.getProductComment(),product.getProductComment()});
    }

    @Override
    public List<Product> getAllProductCommentByProductId(int productId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.ProductRatingCommenting.GET_ALL_COMMENT_BY_PRODUCTID, new Integer[]{productId}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                return mapProductComment(rs);
            }
        });
    }
    
    private Product mapProductComment(ResultSet rs) throws SQLException{
        Product product = new Product();
        product.setUsername(rs.getString("username"));
        product.setProductName(this.getProductName(rs.getInt("productId")));
        product.setProductComment(rs.getString("comment"));
        return product;
    }

    private String getProductName(int productId){
        String productName="";
        productName = jdbcTemplate.queryForObject(SQLConstant.Product.GET_PRODUCT_NAME_BY_ID, new Object[]{productId}, String.class);
        return productName;
    }    

    @Override
    public void subscribeProduct(Product product) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.SubscribeProduct.SUBSCRIBE_PRODUCT, new Object[]{product.getUsername(),
                                                product.getProductId(),
                                                product.getProductSubscriptionDuration(),
                                                product.getProductSubscribeDate()});
    }



}
