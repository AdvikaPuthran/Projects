package com.employee.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.sb.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	public Login findByUserNameAndPassword(String userName, String Password);
}
