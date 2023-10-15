package com.ninja.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ninja.spring.entity.Department;
import com.ninja.spring.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() {
		department = Department.builder()
				.departmentAddress("Mandalay")
				.departmentCode("IT-01")
				.departmentName("IT")
				.departmentId(1L)
				.build();
	}
	
	@Test
	void saveDepartmentTest() throws Exception {
		Department inputDepartment = Department.builder()
				.departmentAddress("Mandalay")
				.departmentCode("IT-01")
				.departmentName("IT")
				.build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment))
			.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
		                "\t\"departmentName\":\"IT\",\n" +
		                "\t\"departmentAddress\":\"Mandalay\",\n" +
		                "\t\"departmentCode\":\"IT-01\"\n" +
		                "}"))
				.andExpect(status().isOk());
	}
	
	@Test
	void getDepartmentById() throws Exception {
		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.departmentName")
						.value(department.getDepartmentName()));
		
	}

}
