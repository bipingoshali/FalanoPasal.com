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
import java.util.Date;
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

    @Override
    public List<Offer> getOffer() throws SQLException, ClassNotFoundException {
        return offerDao.getOffer();
    }

    @Override
    public Offer getOfferById(int offerId) throws SQLException, ClassNotFoundException {
        return offerDao.getOfferById(offerId);
    }

    @Override
    public void updateOffer(Offer offer) throws SQLException, ClassNotFoundException {
        offerDao.updateOffer(offer);
    }

    @Override
    public void deleteOffer(int offerId) throws SQLException, ClassNotFoundException {
        offerDao.deleteOffer(offerId);
    }

    @Override
    public void insertUsersOffers(Offer offer) throws SQLException, ClassNotFoundException {
        //setting the default system date in user enroll date
        Date utilBoughtDate = new Date();
        java.sql.Date sqlBoughtDate = new java.sql.Date(utilBoughtDate.getTime());
        offer.setOfferBoughtDate(sqlBoughtDate);
        
        offerDao.insertUsersOffers(offer);
    }

    @Override
    public Offer getUserBoughtOffers(Offer offer) throws SQLException, ClassNotFoundException {
        return offerDao.getUserBoughtOffers(offer);
    }
    
}
