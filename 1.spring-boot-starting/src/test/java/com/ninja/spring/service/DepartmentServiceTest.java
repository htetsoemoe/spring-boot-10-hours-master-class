package com.ninja.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ninja.spring.entity.Department;
import com.ninja.spring.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setup() {
		Department department = Department.builder()
				.departmentId(100L)
				.departmentName("IT")
				.departmentCode("IT-01")
				.departmentAddress("Mandalay")
				.build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
			.thenReturn(department);
	}
	
	@Test
	@DisplayName("With Valid Department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department foundDepartment = departmentService.getDepartmentByName(departmentName);
		assertEquals(departmentName, foundDepartment.getDepartmentName());
	}

}
