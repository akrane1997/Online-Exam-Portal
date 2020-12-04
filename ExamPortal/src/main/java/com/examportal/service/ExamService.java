package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.model.Exam;
import com.examportal.model.Questions;
import com.examportal.repo.ExamRepository;

@Service
@Transactional
public class ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	public List<Exam> listAllExams() {
		return examRepository.findAll();
	}
	
	public void saveExam(Exam exam) {
		examRepository.save(exam);
	}
	
	public Exam getExamByExamId(long exam_Id) {
		return examRepository.findById((int) exam_Id).get();
	}
	
	public List<Exam> getExamByExamName(String examName) {
		List<Exam> exam=examRepository.findByExam_Name(examName);
		
		return exam;
	}
	
	public List<Exam> getExamByUser_Id(long userId) {
		List<Exam> exam=examRepository.findByUserUserIdentityUser_id(userId);
		return exam;

	}
	
	public void deleteByExamId(int examId) {
		examRepository.deleteById(examId);
	}
}
