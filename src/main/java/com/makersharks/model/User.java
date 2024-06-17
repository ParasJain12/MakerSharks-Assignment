package com.makersharks.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

	@NotEmpty(message = "Username is Required!")
	private String username;
	
	@NotEmpty(message = "Email is Required!")
	private String email;
	
	@NotEmpty(message = "Password is Required!")
	@Size(min = 8, message = "Password should be atleast 8 characters")
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
