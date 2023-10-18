package com.ninja.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
		name = "tbl_student",
		uniqueConstraints = @UniqueConstraint(
				columnNames = "email_address",
				name = "emailid_unique"
		)
)
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",	// create sequence generator named 'student_sequence'
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"	// using sequence generator
	)
	private Long studentId;
	private String firstName;
	private String lastName;
	
	@Column(
			name = "email_address",
			nullable = false
	)
	private String emailId;
	
	@Embedded
	private Guardian guradian;

}
