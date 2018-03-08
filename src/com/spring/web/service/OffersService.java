package com.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.spring.web.dao.Offer;
import com.spring.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;
	
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}


	public List<Offer> getCurrent() {
		return offersDao.getOffers();		
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void create(Offer offer) {
		offersDao.create(offer);
	}


	public boolean hasOffer(String name) {
		if (name == null) return false;
		List<Offer> offers = offersDao.getOffers(name);
		if (offers.isEmpty()) {
			return false;
		}
		return true;
	}


	public Offer getOffer(String username) {
		if(username == null) return null;
		List<Offer> offers = offersDao.getOffers(username);
		if (offers == null)
			return null;
		return offers.get(0);
	}


	public void saveOrUpdate(@Valid Offer offer) {
		if (offer.getId() != 0) {
			offersDao.update(offer);
		} else {
			offersDao.create(offer);
		}		
	}

	public void delete(int id) {
		offersDao.delete(id);		
	}
}
