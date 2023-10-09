package com.ninja.spring.service;

import java.util.List;

import com.ninja.spring.entity.Department;

public interface DepartmentService {
	
	public Department saveDepartment(Department department);
	
	public List<Department> getAllDepartments();

}