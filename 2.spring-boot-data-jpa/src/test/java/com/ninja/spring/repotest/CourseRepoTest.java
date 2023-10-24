package com.ninja.spring.repotest;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ninja.spring.entity.Course;
import com.ninja.spring.entity.Teacher;
import com.ninja.spring.repository.CourseRepository;

@SpringBootTest
public class CourseRepoTest {
	
	@Autowired
	private CourseRepository repo;
	
	@Test
	@Disabled
	public void getAllCourses() {
		List<Course> courses = repo.findAll();
		System.out.println("Courses: %s".formatted(courses.toString()));
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("John")
				.lastName("Doe")
				.build();
		
		Course course = Course.builder()
				.courseName("NodeJS")
				.credit(7)
				.teacher(teacher)
				.build();
		
		repo.save(course);
	}

}
