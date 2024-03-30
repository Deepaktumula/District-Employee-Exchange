package com.techm.project.dee.util;

public class CandidateLogin {
	private String email;
	private String password;

	public CandidateLogin() {
	}

	public CandidateLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
