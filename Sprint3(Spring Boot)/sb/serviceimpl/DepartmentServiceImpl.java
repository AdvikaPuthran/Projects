package com.employee.sb.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.sb.entity.Department;
import com.employee.sb.exception.DepartmentIdNotFoundException;
import com.employee.sb.repository.DepartmentRepository;
import com.employee.sb.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository drepo;

	@Override
	public Department getDeptDetail(int did) {
		return drepo.findById(did).orElseThrow(()-> new DepartmentIdNotFoundException("Incorrect Department id"));
	}

	@Override
	public Department updateDeptDetail(Department department, int did) {
		Department newDept = drepo.findById(did).orElseThrow(()-> new DepartmentIdNotFoundException("Incorrect Department id"));
		
		newDept.setOnOfEmpl(department.getOnOfEmpl());
		newDept.setDeptHOD(department.getDeptHOD());
		
		drepo.save(newDept);
		return newDept;
	}

	@Override
	public List<Department> getAllDept() {
	
		return drepo.findAll();
	}

}

