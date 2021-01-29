package com.examportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.details.MyUserDetails;
import com.examportal.model.Exam;
import com.examportal.model.Exam_user;
import com.examportal.model.Questions;
import com.examportal.model.Score;
import com.examportal.model.User;
import com.examportal.repo.UserRepository;
import com.examportal.service.ExamService;
import com.examportal.service.Exam_UserService;
import com.examportal.service.QuestionService;
import com.examportal.service.UserService;

@Controller

public class ExamController {

	@Autowired
	private ExamService examService;

	@Autowired
	private UserService userService;

	@Autowired
	UserRepository repo;

	@Autowired
	Exam_UserService exam_UserService;

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value="/Exam")
	public String viewHomePage(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
		Long id = userDetails.Id();

		List<Exam> list = examService.getExamByUser_Id(id);
		Exam exam = new Exam();
		model.addAttribute("exam", exam);
		model.addAttribute("list", list);

		return "Exam";
	}

	/*
	 * @RequestMapping("/addExam") public String showNewProductPage(Model model) {
	 * Exam exam = new Exam(); //User user = userService.get(id);
	 * 
	 * //exam.setUser(user); model.addAttribute("exam", exam);
	 * 
	 * return "/Exam"; }
	 */

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public String saveExam(@AuthenticationPrincipal MyUserDetails userDetails,@ModelAttribute("exam") Exam exam,@Param(value="setTime") int setTime) {

		Long id = userDetails.Id();
		System.out.println(id);
		User user=userService.get(id);
		System.out.println(user);
		exam.setUser(user);

		System.out.println("time :"+setTime);


		int sec = setTime * 60;
		exam.setSetTime(sec);

		examService.saveExam(exam);
		return "redirect:/Exam";
	}

	@RequestMapping("/deleteExam/{Exam_Id}")
	public String deleteExam(@PathVariable("Exam_Id") int Exam_Id){
		System.out.println("delete Exam"+Exam_Id);
		examService.deleteByExamId(Exam_Id);
		return "redirect:/Exam";
	}
	//
	//	
	@RequestMapping("/editExam/{Exam_Id}")
	public ModelAndView editExam(@PathVariable("Exam_Id") int Exam_Id) {	
		Exam exam=examService.getExamByExamId(Exam_Id);
		int min=exam.getSetTime() / 60;
		System.out.println("min : "+min);
		exam.setSetTime(min);
		ModelAndView mav = new ModelAndView("Exam");
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

		return "SearchExam";
	}

	@RequestMapping("/addCandidate/{Exam_Id}")
	public String addCandidtae(@AuthenticationPrincipal MyUserDetails userDetails,Model model,@PathVariable("Exam_Id") int Exam_Id) {
		User user=new User();
		model.addAttribute("user", user);
		
		  List<Exam_user> list = exam_UserService.getExam_userByexam_Id(Exam_Id);
		  model.addAttribute("list", list);
		  
		  Long id = userDetails.Id();
			User user1 = userService.getUser(id);
			String role="ROLE_USER";
		 
			List<User> list2 = userService.userList2(role,user1.getInstitute());

	
		model.addAttribute("userList", list2);
		return "AddCandidate";
	}

	@RequestMapping(value = "/addCandidate/{Exam_Id}/saveCandidate", method = RequestMethod.POST)
	public String saveCandidate(@PathVariable("Exam_Id") long Exam_Id,@Param("name") String name) {
		User user=new User();
		user=userService.findByUsername(name);
		long user_Id=user.getUser_Id();
		System.out.println("user id: "+user_Id);
		
		System.out.println("exam Id: "+Exam_Id);
		Exam exam=new Exam();
		Exam_user examuser=new Exam_user();
		exam=examService.getExamByExamId(Exam_Id);
		user=userService.get(user_Id);
		examuser.setUser(user);
		examuser.setExam(exam);
		System.out.println(user.getUser_Id());
		exam_UserService.saveExam_user(examuser);
		return "redirect:/addCandidate/{Exam_Id}";
	}


	@RequestMapping("/addCandidate/{Exam_Id}/delete/{id}")
	public String deletecadidate(@PathVariable("Exam_Id") int Exam_Id,@PathVariable("id") long id){
		exam_UserService.deletecandidatebyid(id);
		return "redirect:/addCandidate/{Exam_Id}";
	}

	@RequestMapping(value="/showExams")
	public String viewexamsforstudent(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
		long id = userDetails.Id();
		List<Exam_user> list = exam_UserService.getExamIdbyuserId(id);
		//List<Exam> list = examService.getExamByUser_Id(id);
//		List<Exam_user> listWithResult=exam_UserService.getResultForExams(list, id);
		System.out.println(id);
		System.out.println("result id: "+list);
		model.addAttribute("list", list);
		System.out.println(id);
		return "ViewExams";
	}

	@RequestMapping(value = "/showExams/{Exam_Id}", method = RequestMethod.GET)
	public String getExamToStudent(@PathVariable("Exam_Id")int Exam_Id,Model model) {
		
		Exam exam=examService.getExamByExamId(Exam_Id);
		int timmer=exam.getSetTime();
		List<Questions> listOfQuestion = questionService.listQuestionsbyExamId(Exam_Id);
		
		model.addAttribute("listOfQuestion", listOfQuestion);
		model.addAttribute("timmer", timmer);

		return "ShowExam";
	}



}
