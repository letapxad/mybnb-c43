package com.mybnb.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mybnb.app.models.Listing;

public interface ListingRepository extends CrudRepository<Listing,Integer>{

	
	@Query("SELECT s from Listing s where s.id = ?1")
	Listing findByListingId(int listing_id);
	
	@Query("SELECT s from Listing s where s.unit = ?1 and s.street_num = ?2 and s.street_name=?3")
	Listing findByAddress(String unit, int snum,String sname);

}
