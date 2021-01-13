package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.model.Feedback;
import com.examportal.service.FeedbackService;

@Controller
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	
	@RequestMapping(value = "/showcontact", method = RequestMethod.GET)
	public String showcontactpage() {
		
		return "/Contact";
	}

	@RequestMapping(value = "/savefeedback", method = RequestMethod.POST)
	public String saveUser(@Param("name") String name,@Param("subject") String subject,@Param("mobilenumber") String mobilenumber,@Param("message") String message) {

		Feedback f=new Feedback();
		f.setName(name);
		f.setSubject(subject);
		f.setMobilenumber(mobilenumber);
		f.setMessage(message);
		feedbackService.save(f);

		return "HomePage";
	}

	@RequestMapping(value = "/listfeedback", method = RequestMethod.GET)
	public String viewallfeedbacks(Model model) {
		List<Feedback> flist = feedbackService.listAll();

		model.addAttribute("flist", flist);
		return "Showfeedback";
	}

}
