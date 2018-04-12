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
    
    //get all offer
    List<Offer> getAllOffer(int orderCount) throws SQLException,ClassNotFoundException;
}
