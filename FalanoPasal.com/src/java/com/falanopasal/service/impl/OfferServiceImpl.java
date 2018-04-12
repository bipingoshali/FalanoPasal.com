/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.service.impl;

import com.falanopasal.dao.OfferDAO;
import com.falanopasal.entity.Offer;
import com.falanopasal.service.OfferService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    private OfferDAO offerDao;
    
    @Override
    public void insertOffer(Offer offer) throws SQLException, ClassNotFoundException {
        offerDao.insertOffer(offer);
    }

    @Override
    public List<Offer> getAllOffer(int orderCount) throws SQLException, ClassNotFoundException {
        return offerDao.getAllOffer(orderCount);
    }
    
}
