package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
	
	

}
