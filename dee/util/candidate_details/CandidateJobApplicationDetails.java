package com.techm.project.dee.util.candidate_details;

import java.sql.Timestamp;

public class CandidateJobApplicationDetails {

	private Timestamp appliedDate;
	private String applicationCode;
	private Boolean status;
	private CandidateJobDetails jobDetails;

	public CandidateJobApplicationDetails() {
		// TODO Auto-generated constructor stub
	}

	public CandidateJobApplicationDetails( Timestamp appliedDate, String applicationCode,
			Boolean status, CandidateJobDetails jobDetails) {
		super();
		this.appliedDate = appliedDate;
		this.applicationCode = applicationCode;
		this.status = status;
		this.jobDetails = jobDetails;
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

	public CandidateJobDetails getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(CandidateJobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}

}
