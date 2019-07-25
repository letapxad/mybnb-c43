package com.mybnb.app.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.Listing;
import com.mybnb.app.models.Renter;

public interface ListingRepository extends JpaRepository<Listing,Integer>, QueryByExampleExecutor<Listing>, ListingRepositoryCustom{
	
	 
	
	 
	@Query("SELECT s from Listing s where s.id = ?1")
	Listing findByListingId(int listing_id);
	
	@Query("SELECT s from Listing s where s.unit = ?1 and s.street_num = ?2 and s.street_name=?3")
	Listing findByAddress(String unit, int snum,String sname);
	
	@Modifying
    @Query("update Listing l set l.active = 0 where l.host = ?1")
    @Transactional
    void deactivateAllListing(Host host);

	@Modifying
	@Query(value = "insert into listing (name, type, latitude, longitude, country, city, street_name, street_num, unit, postal_code_area, postal_code_num, listed_on) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13)", nativeQuery = true)
	@Transactional
    void insertListing(String name, String type, double latitude,
        double longitude, String country, String city, String street_name,
        int street_num, int unit, String postal_code_area, String postal_code_num,
        Date listed_on, int host_id);
	
	@Modifying
	@Query("delete from Listing l where l.id = ?1")
	@Transactional
	void deleteListing(int listing_id);
	
	@Modifying
	@Query("update Listing l set l.active = 0 where l.id = ?1")
	@Transactional
	void deactivateListing(int listing_id);
	
	@Query("SELECT l FROM Listing l INNER JOIN Availability a")
	Iterable<Listing> findAllAvailableListings();
	
}
