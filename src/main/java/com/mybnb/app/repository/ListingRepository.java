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
	@Query(value = "insert into listing (name, type, latitude, longitude, country, city, street_name, street_num, unit, postal_code_area, postal_code_num, listed_on, host_id, active) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, 1)", nativeQuery = true)
	@Transactional
    void insertListing(String name, String type, double latitude,
        double longitude, String country, String city, String street_name,
        int street_num, int unit, String postal_code_area, String postal_code_num,
        java.util.Date listed_on, int host_id);
	
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
	
	@Query(value="SELECT s.*,( 3959 * acos( cos( radians(?2) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?3) ) + sin( radians(?2) ) * sin( radians( latitude ) ) ) ) AS distance FROM Listing s HAVING distance  < ?1 ORDER BY distance",nativeQuery=true)
	List<Listing> findByDistance(int distance, double lat, double lon);

	
	
	
	@Query(value="SELECT s.* from Listing s where "
			+ " s.street_num = ?1 AND"
			+ " s.street_name = ?2 AND"
			+ " s.city = ?3 AND"
			+ " s.country = ?4 AND"
			+ " s.postal_code_area = ?5 AND"
			+ " s.postal_code_num = ?6",nativeQuery = true)
	List<Listing> findByAddress(int street_num, 
								String street_name,
								 String city, 
								 String country, 
								 String postal_code_area,
								 String postal_code_num, 
								 boolean price_low_to_high);
	


	

										//	List<Listing> findByAddress(int street_num, String street_name, String city, String country, String postal_code_area,
//			String postal_code_num, double min_cost, double max_cost ,boolean price_low_to_high);
//	
//	List<Listing> findByAddress(int street_num, String street_name, String city, String country, String postal_code_area,
//			String postal_code_num, double min_cost, double max_cost ,boolean price_low_to_high);
//	
//	@Query("SELECT s.* FROM Listing s where s.date >= checkin AND s.date <= checkout")
//	List<Listing> findByAvailabilty(Date checkin, Date checkout);
	@Query("SELECT l.host from Listing l where l.id = ?1")
	Host getHost(int booking_listing_id);


	@Query(value="select l  FROM Listing l inner join Availability av inner join listing_amenities", nativeQuery = true)
	List<Object[]> findForQuery(String q);


	
}
