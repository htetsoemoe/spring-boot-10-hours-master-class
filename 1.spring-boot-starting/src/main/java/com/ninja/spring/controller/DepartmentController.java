package com.ninja.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.spring.entity.Department;
import com.ninja.spring.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("departments")
	public Department saveDepartment(@RequestBody @Valid Department department) {
		logger.info("invoked saveDepartment endpoint");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("departments")
	public List<Department> getAllDepartments() {
		logger.info("invoked getAllDepartments endpoint");
		return departmentService.getAllDepartments();
	}

	@GetMapping("departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}
	
	@DeleteMapping("departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully!";
	}
	
	@PutMapping("departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}
}
