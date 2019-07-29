package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Renter;
import java.sql.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RenterRepository extends CrudRepository<Renter, Integer>{

  @Modifying
  @Query(value = "insert into renter (active, first_name, last_name, occupation, sin, id, card_num, exp_date) values (?5, ?2, ?3, ?4, ?1, ?6, ?7, ?8)", nativeQuery = true)
  @Transactional
  void insertRenter(int SIN, String first_name, String last_name, String occupation, Boolean active, int id, Long card_num, Date exp_date);
  
  @Modifying
  @Query("update Renter r set r.active = 0 where r.SIN = ?1")
  @Transactional
  void deactivateRenter(int SIN);
  
  @Modifying
  @Query("update Renter r set r.active = 1 where r.SIN = ?1")
  @Transactional
  void activateRenter(int SIN);
  
  @Modifying
  @Query("delete from Renter r where r.SIN = ?1")
  @Transactional
  void deleteRenter(int SIN);
  
  @Query("select r from Renter r where r.SIN = ?1")
  Renter findBySIN(int SIN);

  @Query("SELECT r from Renter r where r.id = ?1")
  Renter findByRenterId(int renter_id);
	
}
