package com.techm.project.dee.util;

public class NewApplication {

	private Long candidateId;
	private Long jobId;

	public NewApplication() {
		// TODO Auto-generated constructor stub
	}

	public NewApplication(Long candidateId, Long jobId) {
		super();
		this.candidateId = candidateId;
		this.jobId = jobId;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

}
