package com.techm.project.dee.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.Job;
import com.techm.project.dee.entity.JobApplicants;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.repository.CandidateRepository;
import com.techm.project.dee.repository.JobApplicationRepository;
import com.techm.project.dee.repository.JobRepository;
import com.techm.project.dee.util.NewApplication;
import com.techm.project.dee.util.RegistrationNumber;

@Service
public class JobApplicationService {

	@Autowired
	JobApplicationRepository applicationRepository;

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	JobRepository jobRepository;

	public void applyJob(NewApplication newApplication) {
		if (newApplication.getCandidateId() != null && newApplication.getJobId() != null) {
			Candidate candidate = candidateRepository.findById(newApplication.getCandidateId()).orElse(null);
			Job job = jobRepository.findById(newApplication.getJobId()).orElse(null);

			if (candidate != null && job != null) {
				// Check if the candidate has already applied for the same job
				boolean hasAppliedForJob = applicationRepository.existsByApplicantIdAndJobID(candidate, job);

				if (!hasAppliedForJob) {
					JobApplicants jobApplicants = new JobApplicants();
					jobApplicants.setApplicantId(candidate);
					jobApplicants.setJobID(job);
					jobApplicants.setAppliedDate(new Timestamp(System.currentTimeMillis()));
					jobApplicants.setApplicationCode(
							RegistrationNumber.generateApplicationCode(job.getTitle(), candidate.getFirstName()));
					jobApplicants.setStatus(false);

					applicationRepository.save(jobApplicants);
				} else {
					throw new IllegalArgumentException("Candidate has already applied for this job");
				}
			} else {
				throw new NotFoundException("Candidate or Job not found with the provided Id");
			}
		} else {
			throw new IllegalArgumentException("CandidateId and JobId must not be null");
		}
	}
}
