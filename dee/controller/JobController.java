package com.techm.project.dee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.project.dee.entity.Job;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	JobService jobService;

	@PostMapping("/add")
	public ResponseEntity<String> saveJob(@RequestBody Job job) {
		try {
			jobService.addJob(job);
			return new ResponseEntity<String>("New Job Added", HttpStatus.CREATED);
		} catch (DuplicateEntryException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/job_code/{jobCode}")
	public ResponseEntity<Object> getJobByJobCode(@PathVariable String jobCode) {
		try {
			Job job = jobService.findByJobCode(jobCode);
			return new ResponseEntity<>(job, HttpStatus.FOUND);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/job_title/{jobTitle}")
	public ResponseEntity<Object> getJobByTitle(@PathVariable String jobTitle) {
		try {
			Job job = jobService.findByJobTitle(jobTitle);
			return new ResponseEntity<>(job, HttpStatus.FOUND);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
