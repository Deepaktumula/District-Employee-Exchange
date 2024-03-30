package com.techm.project.dee.util.candidate_details;

import java.time.Year;

public class CandidateQualificationDetails {

    private String degreeType;
    private String university;
    private Year passOutYear;
    private Double percentage;
 
    public CandidateQualificationDetails() {
		// TODO Auto-generated constructor stub
	}

	public CandidateQualificationDetails(String degreeType, String university, Year passOutYear, Double percentage) {
		super();
		this.degreeType = degreeType;
		this.university = university;
		this.passOutYear = passOutYear;
		this.percentage = percentage;
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