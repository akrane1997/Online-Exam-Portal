package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.Exam_user;
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
	
	public void deletecandidatebyid(long id)
	{
		exam_UserRepo.deleteById(id);
	}
}
