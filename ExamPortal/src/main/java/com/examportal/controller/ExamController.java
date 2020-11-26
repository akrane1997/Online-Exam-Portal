package com.examportal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	
	@RequestMapping(value = "/Exam", method = RequestMethod.GET)
	public ModelAndView ListOfExam(ModelAndView model) {
		List<Exam> listOfExam = examService.listAllExams();
		Exam exam=new Exam();
		User user=new User();
		model.addObject("exam",exam);
		model.addObject("user",user);
		model.addObject("listOfExam", listOfExam);
		model.setViewName("Exam");
		return model;
	}
	
	@RequestMapping(value= "/Exam/add", method = RequestMethod.POST)
	public String addExam (@ModelAttribute("exam") Exam exam,@ModelAttribute("user") User user,@Param("id")int id,@Param("exam_Name")String exam_Name){
		if(exam.getExam_Id() == 0){
			System.out.println("going");
			user.getId();
//			exam.setExam_Id(Exam_Id);
			exam.setExam_Name(exam_Name);
			exam.setUser(user);
			examService.saveExam(exam);		
		}
		else
		{
			System.out.println("not going");
			examService.saveExam(exam);
		}
		return "redirect:/Exam";
	}
	
	@RequestMapping("/deleteExam/{Exam_Id}")
	public String deleteExam(@PathVariable("Exam_Id") int Exam_Id){
		examService.deleteByExamId(Exam_Id);
		return "redirect:/Exam";
	}

	
	@RequestMapping("/editExam/{Exam_Id}")
	public ModelAndView editExam(@PathVariable("Exam_Id") int Exam_Id,ModelAndView model) {	
		Exam exam=examService.getExamByExamId(Exam_Id);
		int id=exam.getExam_Id();
		System.out.println("id"+id);
		model.addObject("exam",exam);
		model.setViewName("Exam");
		return model;
	}
	
	@RequestMapping(value = "/ExamList/{user_Id}", method = RequestMethod.GET)
	public ModelAndView getExamListByUserId(ModelAndView model,@PathVariable("user_Id") int user_Id) {
		List<Exam> listOfExamByUserId = examService.getExamByUser_Id(user_Id);
		model.addObject("listOfExamByUserId", listOfExamByUserId);
		model.setViewName("Exam");
		return model;
	}
	
	@RequestMapping(value = "/ExamList/{Exam_Name}", method = RequestMethod.GET)
	public ModelAndView getListByExamName(ModelAndView model,@PathVariable("Exam_Name") String Exam_Name) {
		List<Exam> listOfExamName = examService.getExamByExamName(Exam_Name);
		model.addObject("listOfExamName", listOfExamName);
		model.setViewName("Exam");
		return model;
	}
	
}
