package com.employee.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.sb.entity.Employee;
import com.employee.sb.service.EmployeeService;

import jakarta.validation.Valid;

//handle all incoming request of Employee Entity
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	//use postmapping to insert data 
	@PostMapping("/Employee/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		return new ResponseEntity<Employee>(es.addEmployee(employee),
				HttpStatus.CREATED);
	}
	
	//use getmapping to fetch data from db table
	@GetMapping("/Employee/getEmployee/{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int eid){
		return new ResponseEntity<Employee>(es.getEmployeeDetail(eid),HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
	@PutMapping("/Employee/editEmployee/{eid}")
	public ResponseEntity<Employee> editTeacher(@Valid @PathVariable("eid") int eid, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(es.updateEmployeeDetail(employee, eid), HttpStatus.OK);
	}
	
	
	//use deletemapping to remove existing data
	@DeleteMapping("Employee/removeEmployee/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") int eid){
		es.deleteEmployeeDetail(eid);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	
	@GetMapping("Employee/getEName/{first_name}")
	public List<Employee> getEmployeeName(@PathVariable("first_name") String first_name){
		return es.getEmployeeByName(first_name);
	}
	
	@GetMapping("Employee/getEPhone/{ephone}")
	public ResponseEntity<Employee> getEmployeePhone(@PathVariable("ephone") long ephone){
		return new ResponseEntity<Employee>(es.getEmployeeByPhone(ephone), HttpStatus.OK);
	}
	
	
	@GetMapping("Employee/getEDesignation/{designation}")
	public List<Employee> getEmployeeDesignation(@PathVariable("designation") String designation){
		return es.getEmployeedesignation(designation);
	}
	


}
