package com.techm.project.dee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.InvalidCredentialsException;
import com.techm.project.dee.exception_handling.UpdatePasswordException;
import com.techm.project.dee.service.LoginService;
import com.techm.project.dee.util.CandidateLogin;
import com.techm.project.dee.util.CandidateSignUp;
import com.techm.project.dee.util.UpdatePassword;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/candidate")
public class LoginController {
	@Autowired
	LoginService loginService;

//	// Registration controller
//	@PostMapping("/signup")
//	public ResponseEntity<String> signUp(@RequestBody CandidateSignUp candidateRegistration) {
//		try {
//			String isCreated = loginService.signUp(candidateRegistration);
//			return ResponseEntity.status(HttpStatus.CREATED).body(isCreated);
//		} catch (DuplicateEntryException e) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//		}
//	}

	// Registration controller
	@PostMapping("/signup")
	public ResponseEntity<Map<String, String>> signUp(@RequestBody CandidateSignUp candidateRegistration) {
		try {
			String isCreated = loginService.signUp(candidateRegistration);
			Map<String, String> response = new HashMap<>();
			response.put("isCreated", isCreated);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (DuplicateEntryException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// Login controller
//	@PutMapping("/signin")
//	public ResponseEntity<String> login(@RequestBody CandidateLogin candidateLogin) {
//		try {
//			String isValidated = loginService.validateCredentials(candidateLogin);
//			return ResponseEntity.status(HttpStatus.OK).body(isValidated);
//		} catch (InvalidCredentialsException e) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//		}
//	}

	// Login controller
	@PutMapping("/signin")
	public ResponseEntity<Map<String, String>> login(@RequestBody CandidateLogin candidateLogin) {
		try {
			String isValidated = loginService.validateCredentials(candidateLogin);
			Map<String, String> response = new HashMap<>();
			response.put("isValidated", isValidated);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (InvalidCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

//	// Password update controller
//	@PutMapping("/update_password")
//	public ResponseEntity<String> updatePassword(@RequestBody UpdatePassword updatePassword) {
//		try {
//			String isUpdated = loginService.updatePassword(updatePassword);
//			return ResponseEntity.status(HttpStatus.OK).body(isUpdated);
//		} catch (UpdatePasswordException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//	}

	// Password update controller
	@PutMapping("/update_password")
	public ResponseEntity<Map<String, String>> updatePassword(@RequestBody UpdatePassword updatePassword) {
		try {
			String isUpdated = loginService.updatePassword(updatePassword);
			Map<String, String> response = new HashMap<>();
			response.put("isUpdated", isUpdated);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (UpdatePasswordException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
