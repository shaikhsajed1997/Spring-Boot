package com.gofly.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gofly.admin.entity.AdminFlight;

@Repository
public interface AdminRepository extends CrudRepository<AdminFlight, String>{

}
