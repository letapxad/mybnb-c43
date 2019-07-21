package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;

import com.mybnb.app.models.Renter;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RenterRepository extends CrudRepository<Renter, Integer>{

	
	
	
}
