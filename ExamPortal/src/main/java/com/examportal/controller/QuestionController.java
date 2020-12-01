package com.examportal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.model.Exam;
import com.examportal.model.Questions;
import com.examportal.service.ExamService;
import com.examportal.service.QuestionService;

@Controller

public class QuestionController {

	@Autowired
	
	private QuestionService questionService;
	
	@Autowired
	private ExamService examService;

	@RequestMapping(value = "/question/{Exam_Id}", method = RequestMethod.GET)
	public ModelAndView ListQestion(ModelAndView model,@PathVariable("Exam_Id") int Exam_Id) {
		System.out.println("Exam id :"+Exam_Id);
		List<Questions> listOfQuestion = questionService.listAllQuestions();
		Questions questions=new Questions();
		model.addObject("questions",questions);
		model.addObject("listOfQuestion", listOfQuestion);
		model.setViewName("Question");
		return model;
	}

	@RequestMapping(value="/question/{Exam_Id}/add", method = RequestMethod.POST)
	public String addQuestion (@ModelAttribute("questions") Questions questions,@PathVariable("Exam_Id") long Exam_Id){
		System.out.println("Exam id :"+Exam_Id);
		
		Exam exam=examService.getExamByExamId(Exam_Id);
		if(questions.getQuestion_Id() == 0){
			System.out.println("jatoy");
			questions.setExam(exam);
			
			questionService.saveQuestion(questions);
		}
		else
		{
			int qId=questions.getQuestion_Id();
			System.out.println("qId: "+qId);
			System.out.println("nahi jat");
			questionService.saveQuestion(questions);
		}
		return "redirect:/question/{Exam_Id}";
	}
	@RequestMapping(value= "/questionUpdate", method = RequestMethod.POST)
	public String updateQuestion (@ModelAttribute("questions") Questions questions){
		int qId=questions.getQuestion_Id();
		System.out.println("qId: "+qId);			
			questionService.saveQuestion(questions);
			return "Question";
		}
	


	@RequestMapping("/deleteQuestion/{question_Id}")
	public String deleteQuestion(@PathVariable("question_Id") int question_Id){
		questionService.deleteQuestionById(question_Id);;
		return "Question";
	}

	@RequestMapping(value="/editQuestion/{question_Id}", method = RequestMethod.GET)
	public String editQuestion(@PathVariable("question_Id") int question_Id,ModelAndView model) {	
		Questions questions=questionService.getQuestionById(question_Id);
		int id=questions.getQuestion_Id();
		System.out.println("id"+id);
		questions.setQuestion_Id(id);
		model.addObject("questions",questions);
		
		return "redirect:/questionUpdate";
	}
}
