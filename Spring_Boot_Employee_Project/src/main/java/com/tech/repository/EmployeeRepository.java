package com.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	public List<Employee> findBySalary(long salary);

	public List<Employee> findBySalaryLessThanEqual(long salary);

	public List<Employee> findBySalaryGreaterThanEqual(long salary);

	@Query(value = "select count(*) from employee where salary=:salary", nativeQuery = true)
	public long getCountOfEmployee(@Param("salary") long salary);

}
