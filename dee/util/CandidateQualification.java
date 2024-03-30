package com.techm.project.dee.util;

import java.time.Year;

public class CandidateQualification {

	private Long candidateId;
	private String degreeType;
	private String university;
	private Year passOutYear;
	private Double percentage;

	public CandidateQualification() {
		// TODO Auto-generated constructor stub
	}

	public CandidateQualification(Long candidateId, String degreeType, String university, Year passOutYear,
			Double percentage) {
		super();
		this.candidateId = candidateId;
		this.degreeType = degreeType;
		this.university = university;
		this.passOutYear = passOutYear;
		this.percentage = percentage;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Year getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(Year passOutYear) {
		this.passOutYear = passOutYear;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
