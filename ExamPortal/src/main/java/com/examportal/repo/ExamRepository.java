package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
