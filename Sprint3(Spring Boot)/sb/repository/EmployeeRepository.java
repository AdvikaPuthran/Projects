package com.employee.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.sb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//jpql
			//Select * from Teacher where tname=?
			
			@Query("Select e from Employee e where e.ephone=?1")
			Employee findEmployeeByPhone(long ephone);
			
			@Query("Select e from Employee e where e.first_name=?1")
			List<Employee> findEmployeeByName(String first_name);
			
			@Query("Select e from Employee e where e.designation like ?1% order by first_name")
			List<Employee> findEmployeeDesignation(String designation);
			
			
	

}
