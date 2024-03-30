package com.techm.project.dee.util;

import java.sql.Timestamp;

public class JobApplicationDetails {

	private String applicationCode;
	private Timestamp appliedDate;
	private Boolean status;
	private String title;
	private String jobCode;
	private String description;
	private String jobLocation;
	private String category;
	private String responsibilities;
	private Double salary;
	
	public JobApplicationDetails() {
		
	}
	
	public JobApplicationDetails(String applicationCode, Timestamp appliedDate, Boolean status, String title,
			String jobCode, String description, String jobLocation, String category, String responsibilities,
			Double salary) {
		super();
		this.applicationCode = applicationCode;
		this.appliedDate = appliedDate;
		this.status = status;
		this.title = title;
		this.jobCode = jobCode;
		this.description = description;
		this.jobLocation = jobLocation;
		this.category = category;
		this.responsibilities = responsibilities;
		this.salary = salary;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public Timestamp getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Timestamp appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
