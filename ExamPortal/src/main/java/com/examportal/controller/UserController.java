package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.examportal.details.MyUserDetails;
import com.examportal.model.Exam;
import com.examportal.model.User;
import com.examportal.repo.UserRepository;
import com.examportal.service.UserService;

@Controller

public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserRepository repo;

	@Autowired(required = true)
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		List<User> list = repo.findByUserBySuperRole();
		model.addAttribute("list", list);
		return "/registration";
	}


	@RequestMapping(value = "/registration_done", method = RequestMethod.POST)
	public String registration( @Param("username") String username, @Param("role") String role,@Param("password") String password,@Param("institute") String institute) {
		//		UserIdentity userIdentity=new UserIdentity();
		User user = new User();
		System.out.println("institute: "+institute);
		if(role.equals("Student"))
		{
			String roleName="ROLE_USER";
			user.setRole(roleName);
		}
		else
		{
			String roleName="ROLE_ADMIN";
			user.setRole(roleName);
		}
		user.setUser_Name(username);;
		user.setInstitute(institute);
		user.setPassword(passwordEncoder.encode(password));
		repo.save(user);

		System.out.println("user added succesfully");

		return "/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {


		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "/login";
	}

	//    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
	//    public String welcome(Model model) {
	//        return "index";
	//    }
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<User> list = service.userList();

		model.addAttribute("list", list);
		return "HomePage";
	}



	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "new_User";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {


		service.save(user);

		return "redirect:/";
	}

	@RequestMapping(value = "/savepassword", method = RequestMethod.POST)
	public String savechangepassword(@ModelAttribute("user") User user,@Param(value = "password") String password) {

		user.setPassword(password);
		service.save(user);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		System.out.println("edit user");
		ModelAndView mav = new ModelAndView("/edit_User");
		User user = service.get(id);
		mav.addObject("user", user);

		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";       
	}

	@RequestMapping("/userinfo")
	public String viewuserInfo(@AuthenticationPrincipal MyUserDetails userDetails,Model model) {
		Long id = userDetails.Id();
		User user = service.getUser(id);

		model.addAttribute("user", user);
		return "UserInfo";
	}

	//	@RequestMapping(value="/changepassword", method = RequestMethod.GET)
	//	public ModelAndView Enternamepage() {
	//		
	//		ModelAndView mv=new ModelAndView();
	//		mv.setViewName("/changepassword");
	//		System.out.println("change password");
	//	
	//
	//		return mv;
	//	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String password2(Model model) {
		model.addAttribute("user", new User());

		return "/changepassword";
	}




	@RequestMapping("/changepassworduser")
	public ModelAndView changepassword(@Param(value = "name") String name) {
		System.out.println("change password 2");
		ModelAndView mav = new ModelAndView("/changepassword2");
		User user = service.findByUsername(name);
		mav.addObject("user", user);

		return mav;
	}
	@RequestMapping("/userList")
	public String viewUserList(@AuthenticationPrincipal MyUserDetails userDetails,Model model) {
		Long id = userDetails.Id();
		User user = service.getUser(id);
		String role="ROLE_USER";
		String userEnable=user.getEnabled();
		System.out.println("User Enable: "+userEnable);
		model.addAttribute("userEnable",userEnable);
		List<User> list = service.userList2(role,user.getInstitute());
		model.addAttribute("list", list);
		return "Studentlist";
	}

	@RequestMapping("/teacherList")
	public String viewTeacherList(@AuthenticationPrincipal MyUserDetails userDetails,Model model) {
		Long id = userDetails.Id();
		User user = service.getUser(id);
		String role="ROLE_ADMIN";
		List<User> list = service.TeacherList(role,user.getInstitute());	
		model.addAttribute("list", list);
		return "Teacherlist";
	}

	@RequestMapping(value = "/CoordinatorRegistration", method = RequestMethod.GET)
	public String CoordinatorRegistration(Model model) {
		model.addAttribute("user", new User());

		return "/CoRegistration";
	}

	@RequestMapping(value = "/CoordinatorRegistration_done", method = RequestMethod.POST)
	public String CoordinatorRegistrationDone( @Param("username") String username, @Param("role") String role,@Param("password") String password, @Param("institute") String institute) {
		System.out.println("Inside Co registration: "+role +" "+username+" "+institute);
		User user = new User();
		if(role.equals("ROLE_SUPER_ADMIN"))
		{
			user.setEnabled("1");
			user.setRole(role);
			user.setInstitute(institute);
		}	

		user.setUser_Name(username);;

		user.setPassword(passwordEncoder.encode(password));

		repo.save(user);

		System.out.println("user added succesfully");

		return "/login";
	}

	@RequestMapping("/enableuser/{id}")
	public ModelAndView Enableuser(@PathVariable(name = "id") int id) {
		System.out.println("enable user id:"+id);
		User user=service.getUser(id);
		//		String pass=user.getPassword();
		//		user.setPassword(pass);
		user.setEnabled("1");

		service.save(user);
		String role1="ROLE_USER";

		ModelAndView mav = new ModelAndView();
		if(role1.equals(user.getRole()))
		{
			String text="Approved";
			mav.addObject("text",text);
			mav.setViewName("redirect:/userList");
		}else {
			String text="Approved";
			mav.addObject("text",text);
			mav.setViewName("redirect:/teacherList");
		}


		return mav;
	}

	@RequestMapping("/deleteuser/{id}")
	public ModelAndView deleteuserbycordinator(@PathVariable(name = "id") int id) {

		System.out.println("enable user id:"+id);
		User user=service.getUser(id);


		String role1="ROLE_USER";

		ModelAndView mav = new ModelAndView();
		if(role1.equals(user.getRole()))
		{
			service.delete(user.getUser_Id());
			mav.setViewName("redirect:/userList");
		}else {
			service.delete(user.getUser_Id());
			mav.setViewName("redirect:/teacherList");
		}

		return mav;       
	}

	@RequestMapping(value = "/approvepage", method = RequestMethod.GET)
	public String approvejsp(Model model) {
		User user=new User();
		model.addAttribute(user);
		return "approve";
	}

	@RequestMapping("/Approval")
	public ModelAndView ApprovalPage(@ModelAttribute("user") User user,@Param("user_Name") String username,ModelAndView model) {
		System.out.println("username check for approval :"+username);
		System.out.println("User name for enable: "+user.getUser_Name());
		String enable="1";
		model.addObject("user",user);
		String enable11=service.findenable(user.getUser_Name());
		model.addObject("enable11",enable11);
		System.out.println("check enable: "+enable11);
		if(enable11==null) {
			System.out.println("user not approved");
			
			  String enableStatusNotApproved= "user not approved";
			  model.addObject("enableStatusNotApproved",enableStatusNotApproved);
			 
		}
		else if(enable11.equals(enable))
		{
			
			  String enableStatusApproved= "user approved.";
			  String enableStatusApproved1="Note :- Firt you must do Forget Password with your User Name.";
			  
			  model.addObject("enableStatusApproved",enableStatusApproved);
			  model.addObject("enableStatusApproved1",enableStatusApproved1);
			System.out.println("user approved");
		}
		model.setViewName("approve");
		return model;
	}



}
