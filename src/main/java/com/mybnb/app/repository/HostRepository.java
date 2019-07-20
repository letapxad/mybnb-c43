package com.mybnb.app.repository;

import org.springframework.stereotype.Repository;

import com.mybnb.app.models.Host;
import com.mybnb.app.models.User;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface HostRepository extends CrudRepository<Host, Integer>{

}
