package com.techm.project.dee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.project.dee.entity.Employer;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.InvalidCredentialsException;
import com.techm.project.dee.exception_handling.UpdatePasswordException;
import com.techm.project.dee.service.EmployerService;
import com.techm.project.dee.util.UpdatePassword;

@RestController
@RequestMapping("/employer")
public class EmployerController {
	@Autowired
	EmployerService employerService;

	// Registration controller
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody Employer employer) {
		try {
			String isCreated = employerService.signUp(employer);
			return ResponseEntity.status(HttpStatus.CREATED).body(isCreated);
		} catch (DuplicateEntryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	// Login controller
	@PutMapping("/signin")
	public ResponseEntity<String> login(@RequestBody Employer employer) {
		try {
			String isValidated = employerService.validateCredentials(employer);
			return ResponseEntity.status(HttpStatus.OK).body(isValidated);
		} catch (InvalidCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	// Password update controller
	@PutMapping("/update_password")
	public ResponseEntity<String> updatePassword(@RequestBody UpdatePassword updatePassword) {
		try {
			String isUpdated = employerService.updatePassword(updatePassword);
			return ResponseEntity.status(HttpStatus.OK).body(isUpdated);
		} catch (UpdatePasswordException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
