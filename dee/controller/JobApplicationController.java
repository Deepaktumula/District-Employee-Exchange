package com.techm.project.dee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.service.JobApplicationService;
import com.techm.project.dee.util.NewApplication;

@RestController
@RequestMapping("/jobs/application")
public class JobApplicationController {

	@Autowired
	JobApplicationService applicationService;

	@PostMapping("apply")
	public ResponseEntity<String> applyNewJob(@RequestBody NewApplication newApplication) {
		try {
			applicationService.applyJob(newApplication);
			return new ResponseEntity<>("Applied", HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
