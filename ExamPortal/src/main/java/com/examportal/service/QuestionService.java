package com.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examportal.model.Questions;
import com.examportal.repo.QuestionRepository;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Questions> listAllQuestions() {
		return questionRepository.findAll();
	}

	public void saveQuestion(Questions questions) {
		questionRepository.save(questions);
	}

	public Questions getQuestionById(int questionId) {
		return questionRepository.findById(questionId).get();
	}

	public void deleteQuestionById(int questionId) {
		questionRepository.deleteById(questionId);
	}
	
	public List<Questions> listQuestionsbyExamId(int examId) {
		return questionRepository.findByExam_Id(examId);
	}
	
	public String getAnswer(int questionId) {
		Questions question=questionRepository.findByAnswer(questionId);
		String answer=question.getAnswer();
		return answer;
	}
	
	
	
}
