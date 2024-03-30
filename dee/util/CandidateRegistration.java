package com.techm.project.dee.util;

import java.time.LocalDate;

public class CandidateRegistration {

	private Long candiateId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String mobile;
	private String gender;

	public CandidateRegistration() {
		// TODO Auto-generated constructor stub
	}

	public CandidateRegistration(Long candiateLoginId, String firstName, String lastName, LocalDate dateOfBirth,
			String mobile, String gender) {
		super();
		this.candiateId = candiateLoginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
		this.gender = gender;
	}

	public Long getCandiateId() {
		return candiateId;
	}

	public void setCandiateId(Long candiateId) {
		this.candiateId = candiateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
