package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.model.Exam_user;
import com.examportal.model.Score;
import com.examportal.repo.Exam_UserRepo;

@Service
public class Exam_UserService {
	
	@Autowired
	Exam_UserRepo  exam_UserRepo;
	
	
	
	public void saveExam_user(Exam_user examuser) {
		exam_UserRepo.save(examuser);
	}
	
	public List<Exam_user> getExam_userByexam_Id(int id) {
		List<Exam_user> exam=exam_UserRepo.findByExam_userbyexamid(id);
		return exam;

	}
	
	public List<Exam_user> getExamIdbyuserId(long id) {
		List<Exam_user> exam=exam_UserRepo.showExamId(id);
		return exam;

	}
	
	public void deletecandidatebyid(long id)
	{
		exam_UserRepo.deleteById(id);
	}
	
	@Transactional
	public List<Exam_user> getResultForExams(List<Exam_user> examList,long id )
	{
		for (Exam_user exam_user : examList) {
			Score score=exam_UserRepo.getScore(exam_user.getExam().getExam_Id(), id);
			score.getScoreid();
			exam_user.setScore(score);
			
		}
		
		return examList;
		
	}


}
