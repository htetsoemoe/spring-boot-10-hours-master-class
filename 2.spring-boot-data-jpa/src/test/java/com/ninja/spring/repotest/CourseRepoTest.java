package com.ninja.spring.repotest;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
	@Disabled
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
	
	// Pagination and Sorting
	@Test
	@Disabled
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 1);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = repo.findAll(firstPageWithThreeRecords).getContent();
		
		long totalElements = repo.findAll(secondPageWithTwoRecords).getTotalElements();
		
		long totalPages = repo.findAll(secondPageWithTwoRecords).getTotalPages();
		
		System.out.println("Content of First Page : " + courses);
		
		System.out.println("Total Elements in Second Page: %d".formatted(totalElements));
		
		System.out.println("Total Pages in Second Page: %d".formatted(totalPages));
		
	}
	
	@Test
	@Disabled
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseName"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, 
															Sort.by("courseName")
															.descending()
															.and(Sort.by("credit")));
		
		List<Course> courses = repo.findAll(sortByTitle).getContent();
		System.out.println("Courses : " + courses);
	}
	
	@Test
	public void findByCourseNameContaining() {
		Pageable firstPageThreeRecords = PageRequest.of(0, 3);
		
		List<Course> courses = repo.findByCourseNameContaining("J", firstPageThreeRecords)
									.getContent();
		
		System.out.println("Courses : " + courses);
	}

}
