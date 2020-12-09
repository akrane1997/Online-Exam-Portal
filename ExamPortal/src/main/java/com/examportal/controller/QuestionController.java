package com.examportal.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.details.MyUserDetails;
import com.examportal.model.Exam;
import com.examportal.model.Questions;
import com.examportal.model.Score;
import com.examportal.model.User;
import com.examportal.service.ExamService;
import com.examportal.service.QuestionService;
import com.examportal.service.Scoreservice;
import com.examportal.service.UserService;

@Controller

public class QuestionController {

	@Autowired

	private QuestionService questionService;

	@Autowired
	private ExamService examService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Scoreservice scoreservice;

	@RequestMapping(value = {"/question/{Exam_Id}"}, method = RequestMethod.GET)

	public ModelAndView ListQestion(ModelAndView model,@PathVariable("Exam_Id") int Exam_Id) {
		System.out.println("Exam id :"+Exam_Id);
		List<Questions> listOfQuestion = questionService.listQuestionsbyExamId(Exam_Id);
		Questions questions=new Questions();
		model.addObject("questions",questions);
		model.addObject("listOfQuestion", listOfQuestion);
		model.setViewName("Question");
		return model;
	}

	@RequestMapping("/question/{Exam_Id}/add")
	public String addQuestion (@ModelAttribute("questions") Questions questions,@PathVariable("Exam_Id") long Exam_Id){
		System.out.println("Exam id addquestion:"+Exam_Id);

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
	//	@RequestMapping(value= "/questionUpdate", method = RequestMethod.POST)
	//	public String updateQuestion (@ModelAttribute("questions") Questions questions){
	//		int qId=questions.getQuestion_Id();
	//		System.out.println("qId: "+qId);			
	//			questionService.saveQuestion(questions);
	//			return "Question";
	//		}

	@RequestMapping(value = "/question/{Exam_Id}/savequestion", method = RequestMethod.POST)
	public String saveQuestion(@ModelAttribute("questions") Questions questions,@PathVariable("Exam_Id") String Exam_Id)
	{
		long num = Long.parseLong(Exam_Id);

		Exam exam=examService.getExamByExamId(num);
		questions.setExam(exam);
		questionService.saveQuestion(questions);

		return "redirect:/question/{Exam_Id}";
	}



	@RequestMapping("/question/{Exam_Id}/deleteQuestion/{question_Id}")
	public String deleteQuestion(@PathVariable("question_Id") int question_Id){
		questionService.deleteQuestionById(question_Id);
		return "redirect:/question/{Exam_Id}";
	}

	//	@RequestMapping(value="/editQuestion/{question_Id}", method = RequestMethod.GET)
	//	public String editQuestion(@PathVariable("question_Id") int question_Id,ModelAndView model) {	
	//		Questions questions=questionService.getQuestionById(question_Id);
	//		int id=questions.getQuestion_Id();
	//		System.out.println("id"+id);
	//		questions.setQuestion_Id(id);
	//		model.addObject("questions",questions);
	//		
	//		return "redirect:/questionUpdate";
	//	}

	@RequestMapping("/question/{Exam_Id}/editQuestion/{question_Id}")
	public ModelAndView showEditQuestion(@PathVariable(name = "question_Id") int id,@PathVariable("Exam_Id") Long Exam_Id) {
		System.out.println("Exam id show edit page:"+Exam_Id);

		Exam exam=examService.getExamByExamId(Exam_Id);

		ModelAndView mav = new ModelAndView("Updatequestion");
		Questions questions =questionService.getQuestionById(id);
		questions.setExam(exam);
		mav.addObject("questions", questions);

		return mav;
	}

	//	@RequestMapping(value ="/submitAnswer" ,method=RequestMethod.POST)
	//	public String submitAnswer(/* HttpServletRequest request, *//* @Param("question_Id") String question_Id */) {
	//		System.out.println("In: ");
	//		int score =0;
	////		String [] questionIds =request.getParameterValues("question_Id");
	////		for(String question_Id : questionIds)
	////		{
	////			System.out.println("Question Ids: "+question_Id);
	////			String answerIdCorrect = questionService.getAnswer(Integer.parseInt(question_Id.trim()));
	////			System.out.println("Question object Ids: "+answerIdCorrect);
	////			if(answerIdCorrect.equals(request.getParameter("question_"+question_Id)))
	////			{
	////				System.out.println("corect answer: "+answerIdCorrect.trim());
	////				score++;
	////			}
	////		}
	////		request.setAttribute("score", score);
	//		return "Result";
	//	}

	@RequestMapping(value ="/showExams/{Exam_Id}/submitAnswer" ,method=RequestMethod.POST)
	public String submitAnswer(@AuthenticationPrincipal MyUserDetails userDetails,HttpServletRequest request,@PathVariable("Exam_Id") int Exam_Id)
	{
		Score result=new Score();
		Long id = userDetails.Id();
		System.out.println(id);
		User user=userService.get(id);
		System.out.println("score in :"+user);
		Exam exam=examService.getExamByExamId(Exam_Id);
		System.out.println("score in :"+exam);
		
		
		
		
		System.out.println("submit answer examid :"+Exam_Id);
		System.out.println("In");
		int score=0;
		String [] questionIds =request.getParameterValues("question_Id".trim());
		for(String question_Id : questionIds)
		{
			System.out.println("Question Ids: "+question_Id);
			String answerIdCorrect = questionService.getAnswer(Integer.parseInt(question_Id.trim()));
			Questions q=questionService.getQuestionById(Integer.parseInt(question_Id.trim()));
			System.out.println("Question object Ids: "+answerIdCorrect);
			String option=request.getParameter("option_"+question_Id.trim());
			System.out.println("option :"+option);
			//			if(answerIdCorrect==(request.getParameter("option_"+question_Id)))
			//			{
			//				System.out.println("correct answer: "+answerIdCorrect);
			//				score++;
			//			}
			System.out.println("option :"+q.getOption1());
			if("option1".equals(option))
			{
				System.out.println("jatoy if1");
				
				if(answerIdCorrect.equals(q.getOption1()))
				{
					System.out.println("Question object Ids 1: "+answerIdCorrect);
					System.out.println("correct option1");
					score++;
				}

			}
			else if("option2".equals(option))
			{
				System.out.println("jatoy if2");
				if(answerIdCorrect.equals(q.getOption2()))
				{
					System.out.println("Question object Ids 2: "+answerIdCorrect);
					System.out.println("correct option2");
					score++;
				}

			} 
			else if("option3".equals(option))
			{
				System.out.println("jatoy if3");
				if(answerIdCorrect.equals(q.getOption3()))
				{
					System.out.println("Question object Ids 3: "+answerIdCorrect);
					System.out.println("correct option3");
					score++;
				}

			}
			else if("option4".equals(option))
			{
				System.out.println("jatoy if4");
				if(answerIdCorrect.equals(q.getOption4()))
				{
					System.out.println("Question object Ids 4: "+answerIdCorrect);
					System.out.println("correct option4");
					score++;
				}

			}
			else {
				System.out.println("option not available");
			}
		}
		result.setExam(exam);
		result.setUser(user);
		result.setScore(score);
		
		scoreservice.saveScore(result);
		request.setAttribute("score", score);
		return"redirect:/result";
	}
	
	
}




