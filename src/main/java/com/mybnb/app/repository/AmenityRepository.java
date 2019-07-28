package com.mybnb.app.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mybnb.app.models.Amenity;

public interface  AmenityRepository extends CrudRepository<Amenity, Integer>{

  @Query(value = "SELECT amenities_name, COUNT(*) AS magnitude FROM listing_amenities GROUP BY amenities_name ORDER BY magnitude desc", nativeQuery= true)
  List<String> getPopularAmenity(Pageable pageable);
  
  
}
