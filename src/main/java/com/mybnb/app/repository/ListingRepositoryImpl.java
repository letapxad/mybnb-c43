package com.mybnb.app.repository;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import com.mybnb.app.models.Listing;

public class ListingRepositoryImpl implements ListingRepositoryCustom {

    @PersistenceContext
	public EntityManager em;
	
	@Autowired
	private ListingRepository listingRepo;

    @Transactional
	@Override
	public void refresh(Listing listing) {
		// TODO Auto-generated method stub
    	em.refresh(listing);
		
	}
	
	@Override
    public List<Listing> findByCustomQuery(String mainQuery, String filters){
    	System.out.println(mainQuery);
    	System.out.println(filters);
    	
    	Query query = em.createNativeQuery(mainQuery + filters, Listing.class);
    	List<Listing> res = query.getResultList();
    	return res;
	}


	@Override
	public List<Object[]> findByListingQuery(String mainQuery){
    	System.out.println(mainQuery);
    	Query query = em.createNativeQuery(mainQuery);
		List<Object[]> lids = query.getResultList();
		// List<Listing> res = listingRepo.findAllById(lids);
    	return lids;
    }
    
    

}
