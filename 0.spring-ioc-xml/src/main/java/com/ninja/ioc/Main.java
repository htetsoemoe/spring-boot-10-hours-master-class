package com.ninja.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ninja.ioc.entity.Doctor;
import com.ninja.ioc.entity.Nurse;
import com.ninja.ioc.entity.Staff;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Doctor doctor = context.getBean(Doctor.class);
		System.out.println("Doctor Qualification : %s".formatted(doctor.getQualification()));
		doctor.assist();
		
		Staff nurse = context.getBean(Nurse.class);
		nurse.assist();
	}

}
