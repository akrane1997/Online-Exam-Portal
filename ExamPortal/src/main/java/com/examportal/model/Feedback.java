package com.examportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	private String name;
	private String subject;
	private String mobilenumber;
	private String message;
	
	public Feedback() {
		super();
	}

	public Feedback(int id, String name, String subject, String mobilenumber, String message) {
		super();
		this.fid = id;
		this.name = name;
		this.subject = subject;
		this.mobilenumber = mobilenumber;
		this.message = message;
	}

	public int getId() {
		return fid;
	}

	public void setId(int id) {
		this.fid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
}
