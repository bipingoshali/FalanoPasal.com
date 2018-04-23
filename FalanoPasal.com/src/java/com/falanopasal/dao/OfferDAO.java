/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao;

import com.falanopasal.entity.Offer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface OfferDAO {
    //insert offer
    void insertOffer(Offer offer) throws SQLException,ClassNotFoundException;
    
    //get all offer by order count
    List<Offer> getAllOffer(int orderCount) throws SQLException,ClassNotFoundException;
    
    //get all offer
    List<Offer> getOffer() throws SQLException,ClassNotFoundException;
    
    //get offer by offer id
    Offer getOfferById(int offerId) throws SQLException,ClassNotFoundException;
    
    //update offer 
    void updateOffer(Offer offer) throws SQLException,ClassNotFoundException;
    
    //delete offer
    void deleteOffer(int offerId) throws SQLException,ClassNotFoundException;
    
    //works when user buys any offers
    void insertUsersOffers(Offer offer) throws SQLException,ClassNotFoundException;
    
    //get those offers that were bought by users
    Offer getUserBoughtOffers(Offer offer) throws SQLException,ClassNotFoundException;
}
