package com.techm.project.dee.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employer")
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private Long employerId;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "last_login")
	private Timestamp lastLogin;

	@Column(name = "last_password_update")
	private Timestamp lastPasswordUpdate;

	@Column(name = "registration_date", nullable = false)
	private Timestamp registrationDate;

	public Employer() {
		// TODO Auto-generated constructor stub
	}

	public Employer(Long employerId, String email, String password, Timestamp lastLogin, Timestamp lastPasswordUpdate,
			Timestamp registrationDate) {
		super();
		this.employerId = employerId;
		this.email = email;
		this.password = password;
		this.lastLogin = lastLogin;
		this.lastPasswordUpdate = lastPasswordUpdate;
		this.registrationDate = registrationDate;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
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

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Timestamp getLastPasswordUpdate() {
		return lastPasswordUpdate;
	}

	public void setLastPasswordUpdate(Timestamp lastPasswordUpdate) {
		this.lastPasswordUpdate = lastPasswordUpdate;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

}
