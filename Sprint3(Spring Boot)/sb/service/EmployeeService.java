package com.employee.sb.service;

import java.util.List;

import com.employee.sb.entity.Employee;

public interface EmployeeService {

	//method for saving employee details in db table
		Employee addEmployee(Employee employee);
		
		//method to fetch employee detail based on id from db table
		Employee getEmployeeDetail(int id);
			
		//method to modify employee detail based on id from db table
		Employee updateEmployeeDetail(Employee employee, int id);
			
		//method to remove employee detail based on id from db table
		void deleteEmployeeDetail(int id);
		
		//method to fetch employee detail based on phone number
		Employee getEmployeeByPhone(long ephone);
			
		//method to fetch employee details based on firstname
		List<Employee> getEmployeeByName(String first_name);
			
		//method to fetch employee details based on first letter of employee
		List<Employee> getEmployeedesignation(String designation);

}
