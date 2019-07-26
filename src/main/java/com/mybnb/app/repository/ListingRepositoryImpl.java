package com.mybnb.app.repository;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Example;
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
    
    public List<Listing> findByCustomQuery(String mainQuery, String filters){
    	System.out.println(mainQuery);
    	System.out.println(filters);
    	
    	Query query = em.createNativeQuery(mainQuery + filters, Listing.class);
    	List<Listing> res = query.getResultList();
    	return res;
    }
    
    

}
