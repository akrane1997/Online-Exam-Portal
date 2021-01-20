package com.examportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long scoreid;
	
	@CreationTimestamp
	//@Generated(GenerationTime.ALWAYS)
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "Given_Exam_Date")
	private Date examdate= new java.sql.Date(new java.util.Date().getTime());
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	Exam exam;
	
	
	
	private int score;

	public Score() {
		super();
	}



	public Score(long scoreid, Date examdate, User user, Exam exam, int score) {
		super();
		this.scoreid = scoreid;
		this.examdate = examdate;
		this.user = user;
		this.exam = exam;
		this.score = score;
	}



	public long getScoreid() {
		return scoreid;
	}

	public void setScoreid(long scoreid) {
		this.scoreid = scoreid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}



	public Date getExamdate() {
		return examdate;
	}



	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}


	
	
	
	

}
