package com.employee.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.sb.entity.Department;
import com.employee.sb.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController{
	
	@Autowired
	DepartmentService ds;
	
	//use postmapping to insert data 
	@PostMapping("/Department/addDepartment")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
		return new ResponseEntity<Department>(ds.addDepartment(department),
		HttpStatus.CREATED);
	}
	
	@GetMapping("/Department/getdept")
	public List<Department> getDept(){
		return ds.getAllDept();
	}
	
	//use getmapping to fetch data from db table
	@GetMapping("/Department/getdept/{did}")
	public ResponseEntity<Department> getDept(@PathVariable("did") int did){
			return new ResponseEntity<Department>(ds.getDeptDetail(did),HttpStatus.OK);
	}
		
	//use putmapping to edit existing data
	@PutMapping("/Department/editdept/{did}")
	public ResponseEntity<Department> editDepartment(@Valid @PathVariable("did") int did, @RequestBody Department department){
		return new ResponseEntity<Department>(ds.updateDeptDetail(department, did), HttpStatus.OK);
	}
}
