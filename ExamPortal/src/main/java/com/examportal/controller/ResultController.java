package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.details.MyUserDetails;
import com.examportal.model.Score;
import com.examportal.service.Scoreservice;

@Controller
public class ResultController {

	@Autowired
	private Scoreservice scoreservice;
	
	@RequestMapping(value="/result")
	public ModelAndView showcandidateScorebyuserId(@AuthenticationPrincipal MyUserDetails userDetails)
	{
		Score result=new Score();
		Long id = userDetails.Id();
		System.out.println(id);
		ModelAndView mv=new ModelAndView("Result");
		List<Score> listOfscore = scoreservice.getScorebyuserId(id);
		mv.addObject("listOfscore", listOfscore);
		return mv;
	}
	
	@RequestMapping(value = "/showresult/{Exam_Id}", method = RequestMethod.GET)
	public ModelAndView Allstudentresultforteacher(@PathVariable("Exam_Id")int Exam_Id,Model model) {
		List<Score> listOfscore = scoreservice.getScoreByexam_Id(Exam_Id);
		ModelAndView mv=new ModelAndView("Result");
		model.addAttribute("listOfscore", listOfscore);

		return mv;
	}
	@RequestMapping(value = "/showresult", method = RequestMethod.GET)
	public ModelAndView ListOfScore(ModelAndView model) {
		List<Score> listOfscore =scoreservice.listAllResult();
		model.addObject("listOfscore", listOfscore);
		model.setViewName("Result");
		return model;
	}
}
