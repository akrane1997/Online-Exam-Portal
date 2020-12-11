package com.examportal.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String raw="ashok";
		String encodedPassword = encoder.encode(raw);
		System.out.println(encodedPassword);
	}
}
