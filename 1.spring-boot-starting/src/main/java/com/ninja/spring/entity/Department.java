package com.ninja.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	@NotBlank(message = "Please Enter Department Name.")
	private String departmentName;
	
	@NotBlank(message = "Please Enter Department Address.")
	private String departmentAddress;
	
	@NotBlank(message = "Please Enter Department Code.")
	private String departmentCode;

}
