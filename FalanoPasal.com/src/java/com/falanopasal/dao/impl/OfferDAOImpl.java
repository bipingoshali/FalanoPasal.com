/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.OfferDAO;
import com.falanopasal.entity.Offer;
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
public class OfferDAOImpl implements OfferDAO{
    
    @Autowired
   private JdbcTemplate jdbcTemplate;

    @Override
    public void insertOffer(Offer offer) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Offer.OFFER_INSERT, new Object[]{offer.getType(),
                                                                offer.getOrderCount(),
                                                                offer.getProductId(),
                                                                offer.getPriceTag()});
    }

    @Override
    public List<Offer> getAllOffer(int orderCount) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Offer.GET_ALL_OFFER_BY_ORDERCOUNT, new Integer[]{orderCount}, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                return mapOfferData(rs);
            }
        });
    }
    
    private Offer mapOfferData(ResultSet rs) throws SQLException{
        Offer offer = new Offer();
        offer.setType(rs.getString("type"));
        offer.setOrderCount(rs.getInt("ordercount"));
        offer.setProductId(rs.getInt("productid"));
        offer.setPriceTag(rs.getDouble("pricetag"));
        return offer;
    }
    
}
