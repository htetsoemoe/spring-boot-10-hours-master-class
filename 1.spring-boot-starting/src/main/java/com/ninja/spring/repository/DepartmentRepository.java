package com.ninja.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.spring.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
