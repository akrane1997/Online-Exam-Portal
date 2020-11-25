package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.examportal.model.Exam;
import com.examportal.model.Questions;
import com.examportal.repo.ExamRepository;

public class ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	public List<Exam> listAllExams() {
		return examRepository.findAll();
	}
	
	public void saveExam(Exam exam) {
		examRepository.save(exam);
	}
	
	public Exam getExamByExamId(int questionId) {
		return examRepository.findById(questionId).get();
	}
	
//	public Exam getExamByExamName(String examName) {
//		return examRepository.findByName(examName).get();
//	}
}
