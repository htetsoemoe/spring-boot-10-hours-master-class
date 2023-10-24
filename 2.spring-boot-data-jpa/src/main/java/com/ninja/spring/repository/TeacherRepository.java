package com.ninja.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.spring.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
