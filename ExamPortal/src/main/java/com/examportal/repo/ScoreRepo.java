package com.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examportal.model.Score;

@Repository
public interface ScoreRepo extends JpaRepository<Score, Long> {
	
	
	@Query("SELECT e FROM Score e WHERE e.exam.Exam_Id = :Exam_Id")
	List<Score> findByScorebyexamid(int Exam_Id);
	
	@Query("SELECT e FROM Score e WHERE e.user.user_Id = :user_Id")
	List<Score> showscoretocandidate(long user_Id);
	
	

}
