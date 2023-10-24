package com.ninja.spring.repotest;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ninja.spring.entity.Course;
import com.ninja.spring.entity.Teacher;
import com.ninja.spring.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepoTest {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	@Disabled
	public void saveTeacher() {
			
		Course courseJava = Course.builder()
				.courseName("Java")
				.credit(7)
				.build();
		
		Course courseDBA = Course.builder()
				.courseName("DBA")
				.credit(7)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Ko")
				.lastName("Htet")
				//.courses(List.of(courseJava, courseDBA))
				.build();
		
		teacherRepository.save(teacher);
	}

}
