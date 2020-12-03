package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examportal.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {


	@Query("select e from Questions e where e.exam.Exam_Id= :examId")
	List<Questions> findByExam_Id(int examId);
}
