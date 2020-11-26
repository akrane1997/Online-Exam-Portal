package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examportal.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
	
	List <Exam> findByUser_Id(long user_Id);
	@Query("select e from Exam e where e.Exam_Name = ?1")
	List<Exam> findByExam_Name(String Exam_Name);
	
}
