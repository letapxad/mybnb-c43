package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mybnb.app.models.Booking;
import com.mybnb.app.models.Host;
import com.mybnb.app.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface HostRepository extends CrudRepository<Host, Integer>{
  
  @Modifying
  @Query(value = "insert into host (active, first_name, last_name, occupation, sin, id) values (?5, ?2, ?3, ?4, ?1, ?6)", nativeQuery = true)
  @Transactional
  void insertHost(int SIN, String first_name, String last_name, String occupation, Boolean active, int id);

}
