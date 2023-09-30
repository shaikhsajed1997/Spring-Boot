package com.tech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.model.Patient;

@Repository
public interface HospitalRepository extends CrudRepository<Patient, String> {

}
