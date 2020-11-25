package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {
//	List<Questions> FindByExamId(int examId);
}
