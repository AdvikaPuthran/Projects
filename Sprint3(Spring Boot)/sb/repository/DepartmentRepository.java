package com.employee.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.sb.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
