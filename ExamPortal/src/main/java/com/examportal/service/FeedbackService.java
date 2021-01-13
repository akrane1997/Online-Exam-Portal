package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.model.Feedback;
import com.examportal.repo.FeedbackRepo;

@Service
@Transactional
public class FeedbackService {
	
	@Autowired
	FeedbackRepo feedbackrepo;
	
	
	public List<Feedback> listAll() {
        return feedbackrepo.findAll();
    }
     
    public void save(Feedback feedback) {
    
    	feedbackrepo.save(feedback);
    }

}
