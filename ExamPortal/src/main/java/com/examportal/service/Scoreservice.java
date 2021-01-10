package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.Exam;
import com.examportal.model.Score;
import com.examportal.repo.ScoreRepo;

@Service
public class Scoreservice {
	
	
	@Autowired
	ScoreRepo scorerepo;
	
	public void saveScore(Score score) {
		scorerepo.save(score);
	}
	
	public List<Score> getScoreByexam_Id(int id) {
		List<Score> exam=scorerepo.findByScorebyexamid(id);
		return exam;

	}
	
	public List<Score> getScorebyuserId(long id) {
		List<Score> exam=scorerepo.showscoretocandidate(id);
		return exam;

	}
	
	public void deletecandidatebyid(long id)
	{
		scorerepo.deleteById(id);
	}
	
	public List<Score> listAllResult() {
		return scorerepo.findAll();
	}
}
