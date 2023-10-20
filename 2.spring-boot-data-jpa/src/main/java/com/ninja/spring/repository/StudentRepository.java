package com.ninja.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ninja.spring.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	// JPA Query Methods 
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String name);
	
	List<Student> findByGuardianName(String guardianName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL with Named Parameter
	@Query("select s from Student s where s.emailId = :emailId")
	Student getStudentByEmailAddress(@Param("emailId") String emailId);
	
	@Query("select s.firstName from Student s where s.emailId = :emailId")
	String getStudentFirstNameByEmail(@Param("emailId") String emailId);
	
	// Native Query
	@Query(
			value = """
					SELECT * FROM tbl_student s 
					WHERE s.email_address = :emailId 
					""",
			nativeQuery = true
	)
	Student getStudentByEmailUsingNativeQuery(@Param("emailId") String emailId);
	
	// Using @Transactional
	@Modifying
	@Transactional
	@Query(
			value = """
					UPDATE tbl_student SET first_name = :firstName
					WHERE email_address = :emailId
					""",
			nativeQuery = true
	)
	int updateStudentFirstNameByEmailId(@Param("firstName") String firstName ,@Param("emailId") String emailId);
}
