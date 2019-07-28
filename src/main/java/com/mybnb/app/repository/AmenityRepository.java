package com.mybnb.app.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Amenity;

public interface  AmenityRepository extends CrudRepository<Amenity, Integer>{

  @Query(value = "SELECT amenities_name, COUNT(*) AS magnitude FROM listing_amenities GROUP BY amenities_name ORDER BY magnitude desc", nativeQuery= true)
  List<String> getPopularAmenity(Pageable pageable);

  @Modifying
  @Query(value = "insert into listing_amenities (amenities_name, listings_id) values (?1, ?2)", nativeQuery = true)
  @Transactional
  void insertAmenity(String name, int listing_id);
  
  //@Query(value = "select amenities_name from temp")
  //List<String> popularAmenity(Pageable pageable);
  
  
}
