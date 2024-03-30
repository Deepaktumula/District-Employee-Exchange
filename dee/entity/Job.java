package com.techm.project.dee.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Long jobId;

	@Column(nullable = false, name = "title", unique = true)
	private String title;

	@Column(nullable = false, name = "job_code", unique = true)
	private String jobCode;

	@Column(nullable = false, name = "description")
	private String description;

	@Column(nullable = false, name = "job_location")
	private String jobLocation;

	@Column(nullable = false, name = "status")
	private Boolean status;

	@Column(nullable = false, name = "category")
	private String category;

	@Column(nullable = false, name = "responsibilities")
	private String responsibilities;

	@Column(nullable = false, name = "posted_date")
	private LocalDate postedDate;

	@Column(nullable = false, name = "deadline")
	private LocalDate deadline;

	@Column(nullable = false, name = "salary")
	private Double salary;

	@OneToMany(mappedBy = "jobID", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private List<JobApplicants> applications;

	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(Long jobId, String title, String jobCode, String description, String jobLocation, Boolean status,
			String category, String responsibilities, LocalDate postedDate, LocalDate deadline, Double salary,
			List<JobApplicants> applications) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.jobCode = jobCode;
		this.description = description;
		this.jobLocation = jobLocation;
		this.status = status;
		this.category = category;
		this.responsibilities = responsibilities;
		this.postedDate = postedDate;
		this.deadline = deadline;
		this.salary = salary;
		this.applications = applications;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<JobApplicants> getApplications() {
		return applications;
	}

	public void setApplications(List<JobApplicants> applications) {
		this.applications = applications;
	}
}