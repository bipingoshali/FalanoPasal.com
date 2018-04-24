/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.OfferDAO;
import com.falanopasal.entity.Offer;
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
        offer.setOfferId(rs.getInt("offerid"));
        offer.setType(rs.getString("type"));
        offer.setOrderCount(rs.getInt("ordercount"));
        offer.setProductId(rs.getInt("productid"));
        offer.setPriceTag(rs.getDouble("pricetag"));
        offer.setProductName(this.getProductName(rs.getInt("productid")));
        return offer;
    }

    private String getProductName(int productId){
        String productName="";
        productName = jdbcTemplate.queryForObject(SQLConstant.Product.GET_PRODUCT_NAME_BY_ID, new Object[]{productId}, String.class);
        return productName;
    }    
    
    @Override
    public List<Offer> getOffer() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Offer.GET_ALL_OFFER, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                return mapOfferData(rs);
            }
        });
    }

    @Override
    public Offer getOfferById(int offerId) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.queryForObject(SQLConstant.Offer.GET_ALL_OFFER_BY_ID, new Object[]{offerId}, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                return mapOfferData(rs);
            }
        });
    }

    @Override
    public void updateOffer(Offer offer) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Offer.UPDATE_OFFER_DETAILS, new Object[]{offer.getType(),offer.getOrderCount(),offer.getPriceTag(),offer.getOfferId()});
    }

    @Override
    public void deleteOffer(int offerId) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Offer.DELETE_OFFER, new Object[]{offerId});
    }

    @Override
    public void insertUsersOffers(Offer offer) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.Offers_Users.OFFERS_USERS_INSERT, 
                new Object[]{offer.getUsername(),offer.getOfferId(),offer.getOfferBoughtDate()});
    }

    @Override
    public Offer getUserBoughtOffers(Offer offer) throws SQLException, ClassNotFoundException {
        List<Offer> fetchUserBoughtOffers = jdbcTemplate.query(SQLConstant.Offers_Users.GET_USER_OFFER_BOUGHT, new Object[]{offer.getUsername(),offer.getOfferId()}, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                return mapUserOffersData(rs);
            }
        });
        return fetchUserBoughtOffers.size() > 0 ? fetchUserBoughtOffers.get(0):null;
        
    }
    
    private Offer mapUserOffersData(ResultSet rs) throws SQLException{
        Offer offer = new Offer();
        offer.setUsername(rs.getString("username"));
        offer.setOfferId(rs.getInt("offerid"));
        offer.setOfferBoughtDate(rs.getDate("date"));
        return offer;
    }

    private Offer mapUserOffersDataHistory(ResultSet rs) throws SQLException{
        Offer offer = new Offer();
        offer.setUsername(rs.getString("username"));
        offer.setOfferId(rs.getInt("offerid"));
        offer.setOfferBoughtDate(rs.getDate("date"));
        offer.setType(rs.getString("type"));
        offer.setPriceTag(rs.getDouble("pricetag"));
        offer.setProductName(this.getProductName(rs.getInt("productid")));        
        return offer;
    }

    @Override
    public List<Offer> getUserOffersHistory(String username) throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Offers_Users.GET_USER_OFFER, new String[]{username}, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                return mapUserOffersDataHistory(rs);
            }
        });
    }

    @Override
    public List<Offer> getAllOffersBought() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.Offers_Users.GET_ALL_USER_OFFER, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                return mapUserOffersDataHistory(rs);
            }
        });
    }
    
    
}
