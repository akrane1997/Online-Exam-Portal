package com.examportal.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Exam_Id;
	private String Exam_Name;
	
	//@Temporal(TemporalType.DATE)

	@CreationTimestamp
	//@Generated(GenerationTime.ALWAYS)
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "date")
	private Date startDate= new java.sql.Date(new java.util.Date().getTime());
	
	private int setTime= 0 ;
	

	
	@OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
	private List<Questions> question=new ArrayList<Questions>();
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;

//	@ManyToOne
//	@JoinTable(
//			name = "Exam_user", 
//			joinColumns = { @JoinColumn(name = "exam_Id")}, 
//			inverseJoinColumns = { @JoinColumn(name = "user_Id") }
//			)
//	private User user1;
	
//	@OneToMany(mappedBy = "Exam1", cascade = CascadeType.ALL)
//	private List<User> user1=new ArrayList<User>();
	
    @ManyToMany(mappedBy = "exam")
    List<Exam_user> examuser;
	
    @ManyToMany(mappedBy = "exam")
    List<Score> examuserscore;
    
 
    
	public Exam() {
		super();
	}

	public Exam(int exam_Id, String exam_Name, List<Questions> question, User user, List<Exam_user> examuser) {
		super();
		Exam_Id = exam_Id;
		Exam_Name = exam_Name;
		this.question = question;
		this.user = user;
		this.examuser = examuser;
	}

	public Exam(int exam_Id, String exam_Name, Date startDate, List<Questions> question, User user,
			List<Exam_user> examuser, List<Score> examuserscore) {
		super();
		Exam_Id = exam_Id;
		Exam_Name = exam_Name;
		this.startDate = startDate;
		this.question = question;
		this.user = user;
		this.examuser = examuser;
		this.examuserscore = examuserscore;
	}

	public int getSetTime() {
		return setTime;
	}

	public void setSetTime(int setTime) {
		this.setTime = setTime;
	}

	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public List<Score> getExamuserscore() {
		return examuserscore;
	}





	public void setExamuserscore(List<Score> examuserscore) {
		this.examuserscore = examuserscore;
	}





	public int getExam_Id() {
		return Exam_Id;
	}
	public void setExam_Id(int exam_Id) {
		Exam_Id = exam_Id;
	}
	public String getExam_Name() {
		return Exam_Name;
	}
	public void setExam_Name(String exam_Name) {
		Exam_Name = exam_Name;
	}
	public List<Questions> getQuestion() {
		return question;
	}
	public void setQuestion(List<Questions> question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}





	public List<Exam_user> getExamuser() {
		return examuser;
	}


	public void setExamuser(List<Exam_user> examuser) {
		this.examuser = examuser;
	}





	

	

}
