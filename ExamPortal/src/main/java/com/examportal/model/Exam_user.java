package com.examportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exam_user {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "scoreid")
	Score score;
	
	public Exam_user() {
		super();
	}

	public Exam_user(long id, User user, Exam exam, Score score) {
		super();
		this.id = id;
		this.user = user;
		this.exam = exam;
		this.score = score;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	




}
