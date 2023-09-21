package com.tech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.model.Train;
@Repository
public interface TrainRepository extends CrudRepository<Train, String>{

}
