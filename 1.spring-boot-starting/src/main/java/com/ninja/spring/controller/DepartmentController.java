package com.ninja.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.spring.entity.Department;
import com.ninja.spring.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("departments")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

}
