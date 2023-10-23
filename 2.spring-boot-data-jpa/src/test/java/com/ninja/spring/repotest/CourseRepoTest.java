package com.ninja.spring.repotest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ninja.spring.entity.Course;
import com.ninja.spring.repository.CourseRepository;

@SpringBootTest
public class CourseRepoTest {
	
	@Autowired
	private CourseRepository repo;
	
	@Test
	public void getAllCourses() {
		List<Course> courses = repo.findAll();
		System.out.println("Courses: %s".formatted(courses.toString()));
	}

}
