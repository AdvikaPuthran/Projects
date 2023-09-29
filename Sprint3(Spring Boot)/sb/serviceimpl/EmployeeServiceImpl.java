package com.employee.sb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.sb.entity.Employee;
import com.employee.sb.exception.EmployeeIdNotFoundException;
import com.employee.sb.repository.EmployeeRepository;
import com.employee.sb.service.EmployeeService;

//business logic(CRUD Implementation) of entity teacher
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository erepo;

	//use save() of Jpa repository for saving details
	@Override
	public Employee addEmployee(Employee employee) {
		
		return erepo.save(employee);
	}
	
//use findById of Jpa repository for fetching record if not found
	//then throw custom exception
	@Override
	public Employee getEmployeeDetail(int eid) {
		return erepo.findById(eid).
     orElseThrow(()-> new EmployeeIdNotFoundException("Employee Id is not correct"));
	}
	
	//use findById of Jpa repository for fetching record if not found
	//then throw custom exception
	// if found update phone,designation & save new records
	@Override
	public Employee updateEmployeeDetail(Employee employee, int eid) {
	Employee updatedEmployee = erepo.findById(eid).
	         orElseThrow(()-> new EmployeeIdNotFoundException("Employee Id is not correct"));

	//set new values
	updatedEmployee.setEphone(employee.getEphone());
	updatedEmployee.setDesignation(employee.getDesignation());
	
	erepo.save(updatedEmployee); //saving updated details 
		return updatedEmployee; 
	}


	//use findById of Jpa repository for fetching record if not found
	//then throw custom exception
	//if found use deleteById to remove record
	@Override
	public void deleteEmployeeDetail(int eid) {
		erepo.findById(eid).
		orElseThrow(()-> new EmployeeIdNotFoundException("Employee Id is not correct"));
	    erepo.deleteById(eid);
	}

	@Override
	public Employee getEmployeeByPhone(long ephone) {
		// TODO Auto-generated method stub
		return erepo.findEmployeeByPhone(ephone);
	}

	@Override
	public List<Employee> getEmployeeByName(String first_name) {
		// TODO Auto-generated method stub
		return erepo.findEmployeeByName(first_name);
	}

	@Override
	public List<Employee> getEmployeedesignation(String designation) {
		// TODO Auto-generated method stub
		return erepo.findEmployeeDesignation(designation);
	}

}
