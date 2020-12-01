package com.examportal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examportal.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {

//	@Query("Select e from Questions e where e.exam_id= ?1")
//	 Optional<Questions> findByExam_Id(int id);
//	@Query("Select e from Questions e where e.exam_id= ?1")
//	List <Questions> findByexam_id(int exam_Id);
	//@Query("select e from Questions e where e.Exam_Id = ?1")
//	List<Questions> findByExam_Id(long examId);
}
