package com.tech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>{

}
