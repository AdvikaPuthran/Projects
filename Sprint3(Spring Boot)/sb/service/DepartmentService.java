package com.employee.sb.service;

import java.util.List;

import com.employee.sb.entity.Department;

public interface DepartmentService {
	
	Department getDeptDetail(int did);
	
	List<Department> getAllDept();
		
	Department updateDeptDetail(Department department, int did);
}
