package com.mybnb.app.repository;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;


import org.springframework.transaction.annotation.Transactional;

import com.mybnb.app.models.Listing;

public class ListingRepositoryImpl implements ListingRepositoryCustom {

    @PersistenceContext
    public EntityManager em;

    @Transactional
	@Override
	public void refresh(Listing listing) {
		// TODO Auto-generated method stub
    	em.refresh(listing);
		
	}

}
