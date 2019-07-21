package com.mybnb.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mybnb.app.models.Listing;

public interface ListingRepository extends CrudRepository<Listing,Integer>{

	
	@Query("SELECT s from Listing s where s.id = ?1")
	Listing findByListingId(int listing_id);

}
