package com.examportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Embeddable
public class UserIdentity implements Serializable{

//	@Id
//	@GenericGenerator(name = "sequence_user_id", strategy = "com.examportal.model.UserIdGenerator")
//	@GeneratedValue(generator = "sequence_user_id")  '
	
	@Column(name="user_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_Id;
	
	private String user_Name;

	public UserIdentity(long user_Id, String user_Name) {
		super();
		this.user_Id = user_Id;
		this.user_Name = user_Name;
	}

	public UserIdentity() {
		super();
	}

	public long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	
	
	
	
	
}
