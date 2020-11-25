package com.examportal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.examportal.model.Questions;
import com.examportal.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {
		List<Questions> listOfQuestion = questionService.listAllQuestions();
		Questions questions=new Questions();
		model.addObject("questions",questions);
		model.addObject("listOfQuestion", listOfQuestion);
		model.setViewName("Question");
		return model;
	}

	@RequestMapping(value= "/question/add", method = RequestMethod.POST)
	public String addQuestion (@ModelAttribute("questions") Questions questions){
		if(questions.getQuestion_Id() == 0){
			System.out.println("jatoy");
			questionService.saveQuestion(questions);
		}
		else
		{
			System.out.println("nahi jat");
			questionService.saveQuestion(questions);
		}
		return "redirect:/question";
	}


	@RequestMapping("/deleteQuestion/{question_Id}")
	public String deleteQuestion(@PathVariable("question_Id") int question_Id){
		questionService.deleteQuestionById(question_Id);;
		return "redirect:/question";
	}

	@RequestMapping("/editQuestion/{question_Id}")
	public ModelAndView editQuestion(@PathVariable("question_Id") int question_Id,ModelAndView model) {	
		Questions questions=questionService.getQuestionById(question_Id);
		int id=questions.getQuestion_Id();
		System.out.println("id"+id);
		model.addObject("questions",questions);
		model.setViewName("Question");
		return model;
	}
}
