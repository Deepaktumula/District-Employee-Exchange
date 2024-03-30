package com.techm.project.dee.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private Long loginId;

	@Column(nullable = false, unique = true, name = "email")
	private String email;

	@Column(nullable = false, name = "password")
	private String password;

	@Column(name = "last_login")
	private Timestamp lastLogin;

	@Column(name = "last_password_update")
	private Timestamp lastPasswordUpdate;

	@Column(nullable = false, name = "registration_date")
	private Timestamp registrationDate;

	@OneToOne(mappedBy = "candiateLoginId", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Candidate candiateLoginId;

	public Login() {
		super();
	}

	public Login(Long loginId, String email, String password, Timestamp lastLogin, Timestamp lastPasswordUpdate,
			Timestamp registrationDate) {
		super();
		this.loginId = loginId;
		this.email = email;
		this.password = password;
		this.lastLogin = lastLogin;
		this.lastPasswordUpdate = lastPasswordUpdate;
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
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

	public Candidate getCandiateLoginId() {
		return candiateLoginId;
	}

	public void setCandiateLoginId(Candidate candiateLoginId) {
		this.candiateLoginId = candiateLoginId;
	}

}
