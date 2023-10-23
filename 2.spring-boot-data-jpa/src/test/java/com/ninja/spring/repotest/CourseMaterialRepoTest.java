package com.ninja.spring.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ninja.spring.entity.Course;
import com.ninja.spring.entity.CourseMaterial;
import com.ninja.spring.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepoTest {
	
	@Autowired
	private CourseMaterialRepository repo;
	
	@Test
	@Disabled
	public void saveCourseMaterial() {
		Course course = Course.builder()
				.courseName("Spring Boot Cloud")
				.credit(7)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.google-drive.com")
				.course(course)
				.build();
		
		CourseMaterial savedMaterial = repo.save(courseMaterial);
		
		assertEquals("www.google-drive.com", savedMaterial.getUrl());
	}
	
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterials = repo.findAll();
		System.out.println("Course Materials: %s".formatted(courseMaterials.toString()));
	}

}
