package com.techm.project.dee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.project.dee.entity.Job;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	JobRepository jobRepository;

	public String addJob(Job job) {
		if (jobRepository.findByJobCode(job.getJobCode()).isPresent()) {
			throw new DuplicateEntryException("Duplicate entry for Job Code");
		} else if (jobRepository.findByTitle(job.getTitle()).isPresent()) {
			throw new DuplicateEntryException("Duplicate entry for Job Title");
		} else {
			jobRepository.save(job);
			return "Saved";
		}
	}

	public Job findByJobCode(String jobCode) {
		if (jobRepository.findByJobCode(jobCode).isPresent()) {
			return jobRepository.findByJobCode(jobCode).orElse(null);
		} else {
			throw new NotFoundException("Job not found with the given jobCode");
		}
	}

	public Job findByJobTitle(String jobTitle) {
		if (jobRepository.findByTitle(jobTitle).isPresent()) {
			return jobRepository.findByTitle(jobTitle).orElse(null);
		} else {
			throw new NotFoundException("Job not found with the given jobTitle");
		}
	}
}
