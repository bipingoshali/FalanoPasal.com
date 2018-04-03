/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.CategoryDAO;
import com.falanopasal.entity.Category;
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
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategory() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Category.GET_CATEGORY, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return mapCategoryData(rs);
            }
        });

    }

    private Category mapCategoryData(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategoryId(rs.getInt("categoryId"));
        category.setCategoryName(rs.getString("categoryName"));
        return category;
    }

}
