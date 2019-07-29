package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.Renter;
import com.mybnb.app.models.User;
import java.sql.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface HostRepository extends CrudRepository<Host, Integer>{
  
  @Modifying
  @Query(value = "insert into host (active, first_name, last_name, occupation, sin, dob) values (1, ?2, ?3, ?4, ?1, ?6)", nativeQuery = true)
  @Transactional
  void insertHost(int SIN, String first_name, String last_name, String occupation, Date DOB);
  
  @Query("select h from Host h where h.SIN = ?1")
  Host findBySIN(int SIN);
  
  @Modifying
  @Query("update Host h set h.active = 0 where h.SIN = ?1")
  @Transactional
  void deactivateHost(int SIN);
  
  @Modifying
  @Query("update Host h set h.active = 1 where h.SIN = ?1")
  @Transactional
  void activateHost(int SIN);
  
  @Modifying
  @Query("delete from Host h where h.SIN = ?1")
  @Transactional
  void deleteHost(int SIN);
  
  //@Transactional 
  //@Query("insert into host (active, first_name, last_name, occupation, sin) values (?5, ?2, ?3, ?4, ?1)")
  //void insertHost(int SIN, String first_name, String last_name, String occupation, Boolean active);
  @Query("select h from Host h where h.id = ?1")
  Host findByHostId(int host_id);


}
 