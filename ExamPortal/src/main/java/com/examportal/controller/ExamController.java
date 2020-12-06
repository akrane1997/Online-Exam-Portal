package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.details.MyUserDetails;
import com.examportal.model.Exam;
import com.examportal.model.User;
import com.examportal.service.ExamService;
import com.examportal.service.UserService;

@Controller

public class ExamController {

	@Autowired
	private ExamService examService;

	@Autowired
	private UserService userService;

	@RequestMapping(value="/Exam")
	public String viewHomePage(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
		Long id = userDetails.Id();

		List<Exam> list = examService.getExamByUser_Id(id);
		
		model.addAttribute("list", list);
	
		return "/exampage";
	}

	@RequestMapping("/addExam")
	public String showNewProductPage(Model model) {
		Exam exam = new Exam();
		//User user = userService.get(id);

		//exam.setUser(user);
		model.addAttribute("exam", exam);

		return "/addexam";
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public String saveExam(@AuthenticationPrincipal MyUserDetails userDetails,@ModelAttribute("exam") Exam exam) {

		Long id = userDetails.Id();
		System.out.println(id);
		User user=userService.get(id);
		System.out.println(user);
		exam.setUser(user);
		examService.saveExam(exam);
		return "redirect:/Exam";
	}
	
	@RequestMapping("/deleteExam/{Exam_Id}")
	public String deleteExam(@PathVariable("Exam_Id") int Exam_Id){
		examService.deleteByExamId(Exam_Id);
		return "redirect:/Exam";
	}
	//
	//	
	@RequestMapping("/editExam/{Exam_Id}")
	public ModelAndView editExam(@PathVariable("Exam_Id") int Exam_Id) {	
		Exam exam=examService.getExamByExamId(Exam_Id);
		ModelAndView mav = new ModelAndView("/edit_exam");
		mav.addObject("exam",exam);
		
		return mav;
	}


	@RequestMapping(value = "/ExamList", method = RequestMethod.GET)
	public String getListByExamName(@ModelAttribute("exam") Exam exam,Model mv) {
		
		mv.addAttribute("exam",exam);
		String Examname=exam.getExam_Name();
		System.out.println(Examname);
		List<Exam> Elist = examService.getExamByExamName(Examname);
		mv.addAttribute("Elist", Elist);
	
		return "/searchexam";
	}
	
	@RequestMapping("/addCandidate/{Exam_Id}")
	public String addCandidtae(Model model,@PathVariable("Exam_Id") int Exam_Id) {
		
		User user=new User();
		

		//exam.setUser(user);
		model.addAttribute("user", user);
//		model.addAttribute("listOfExams", listOfExams);

		return "AddCandidate";
	}
	
	@RequestMapping(value = "/addCandidate/{Exam_Id}/saveCandidate", method = RequestMethod.POST)
	public String saveCandidate(@ModelAttribute("user") User user,@PathVariable("Exam_Id") long Exam_Id) {
		System.out.println("exam Id: "+Exam_Id);
		Exam exam=new Exam();
		
		exam=examService.getExamByExamId(Exam_Id);
		user.setExam1(exam);
		userService.save(user);
		return "redirect:/Exam";
	}
}
