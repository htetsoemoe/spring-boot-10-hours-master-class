package com.ninja.spring.repotest;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ninja.spring.entity.Guardian;
import com.ninja.spring.entity.Student;
import com.ninja.spring.repository.StudentRepository;

@SpringBootTest
public class StudentRepoTest {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	@Disabled
	void studentWithGuardianTest() {
		Guardian guardian = Guardian.builder()
				.name("James Bond")
				.email("bond@mi6.com")
				.phone("0900000007")
				.build();
		
		var student = Student.builder()
				.firstName("John")
				.lastName("Bond")
				.emailId("john@school.com")
				.guardian(guardian)
				.build();
		
		studentRepo.save(student);
	}
	
	@Test
	@Disabled
	void getAllStudentsTest() {
		List<Student> students = studentRepo.findAll();
		System.out.println("Students: %s".formatted(students.toString()));
	}
	
	@Test
	@Disabled
	void findByFirstNameTest() {
		List<Student> students = studentRepo.findByFirstName("John");
		System.out.println("Students: %s".formatted(students.toString()));
	}
	
	@Test
	void findByFirstNameContaining() {
		List<Student> students = studentRepo.findByFirstNameContaining("J");
		System.out.println("Students: %s".formatted(students.toString()));
	}
	
	@Test
	@Disabled
	void findByGuardianName() {
		List<Student> students = studentRepo.findByGuardianName("James Bond");
		System.out.println("Students: %s".formatted(students.toString()));
	}
	
	@Test
	void findByFirstNameAndLastName() {
		Student found = studentRepo.findByFirstNameAndLastName("John", "Bond");
		System.out.println("Students: %s".formatted(found.toString()));
	}

}
