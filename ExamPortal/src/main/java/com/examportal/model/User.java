package com.examportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class User {
 
	@EmbeddedId
	private UserIdentity userIdentity;
    private String password;
    private String role;
    private String enabled;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Exam> exam=new ArrayList<Exam>();
    
   
	public User() {
		super();
	}
	
	public User(UserIdentity userIdentity, String password, String role, String enabled, List<Exam> exam) {
		super();
		this.userIdentity = userIdentity;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.exam = exam;
	}
	
	
	public UserIdentity getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(UserIdentity userIdentity) {
		this.userIdentity = userIdentity;
	}

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
 
   
}