package com.techm.project.dee.util.candidate_details;

public class CandidateJobDetails {

	private String title;
	private String jobCode;
	private String jobLocation;
	private String category;
	private String responsibilities;
	private Double salary;

	public CandidateJobDetails() {
		// TODO Auto-generated constructor stub
	}

	public CandidateJobDetails(String title, String jobCode, String jobLocation, String category,
			String responsibilities, Double salary) {
		super();
		this.title = title;
		this.jobCode = jobCode;
		this.jobLocation = jobLocation;
		this.category = category;
		this.responsibilities = responsibilities;
		this.salary = salary;
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
