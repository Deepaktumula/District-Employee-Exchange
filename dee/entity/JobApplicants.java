package com.techm.project.dee.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_applicant")
public class JobApplicants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private Long applicationId;

	@ManyToOne
	@JoinColumn(name = "candidate_id", nullable = false)
	@JsonBackReference
	private Candidate applicantId;

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	@JsonBackReference
	private Job jobID;

	@Column(name = "applied_date", nullable = false)
	private Timestamp appliedDate;

	@Column(name = "application_code", nullable = false, unique = true)
	private String applicationCode;

	@Column(name = "status", nullable = false, columnDefinition = "int default 0")
	private Boolean status;

	public JobApplicants() {
		super();
	}

	public JobApplicants(Long applicationId, Candidate applicantId, Job jobID, Timestamp appliedDate,
			String applicationCode, Boolean status) {
		super();
		this.applicationId = applicationId;
		this.applicantId = applicantId;
		this.jobID = jobID;
		this.appliedDate = appliedDate;
		this.applicationCode = applicationCode;
		this.status = status;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Candidate getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Candidate applicantId) {
		this.applicantId = applicantId;
	}

	public Job getJobID() {
		return jobID;
	}

	public void setJobID(Job jobID) {
		this.jobID = jobID;
	}

	public Timestamp getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Timestamp appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
