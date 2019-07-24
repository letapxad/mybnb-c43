package com.mybnb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;

public interface ListingRepository extends JpaRepository<Listing,Integer>{

	
	@Query("SELECT s from Listing s where s.id = ?1")
	Listing findByListingId(int listing_id);
	
	@Query("SELECT s from Listing s where s.unit = ?1 and s.street_num = ?2 and s.street_name=?3")
	Listing findByAddress(String unit, int snum,String sname);
	
	@Modifying
    @Query("update Listing l set l.active = 0 where l.host = ?1")
    @Transactional
    void deactivateAllListing(Host host);

}
