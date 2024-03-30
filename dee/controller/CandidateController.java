package com.techm.project.dee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.project.dee.exception_handling.CandidateProfileAlreadyExistException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.service.CandidateService;
import com.techm.project.dee.util.CandidateRegistration;
import com.techm.project.dee.util.candidate_details.CandidateAddressDetails;
import com.techm.project.dee.util.candidate_details.CandidateDetails;
import com.techm.project.dee.util.candidate_details.CandidateJobApplicationDetails;
import com.techm.project.dee.util.candidate_details.CandidateQualificationDetails;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/candidate/profile")
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@GetMapping("/get/{candidateId}/all")
	public ResponseEntity<Object> getCandidateById(@PathVariable Long candidateId) {
		try {
			CandidateDetails candidate = candidateService.findCandidateById(candidateId);
			return new ResponseEntity<>(candidate, HttpStatus.FOUND);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/{candidateId}/address")
	public ResponseEntity<Object> getCandidateAddress(@PathVariable Long candidateId) {
		try {
			CandidateAddressDetails addressDetails = candidateService.findCandidateById(candidateId)
					.getAddressDetails();
			return new ResponseEntity<>(addressDetails, HttpStatus.FOUND);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/{candidateId}/qualifications")
	public ResponseEntity<Object> getCandidateQualifications(@PathVariable Long candidateId) {

		try {
			List<CandidateQualificationDetails> qualificationDetails = candidateService.findCandidateById(candidateId)
					.getQualificationDetails();
			return new ResponseEntity<>(qualificationDetails, HttpStatus.FOUND);
		} catch (NotFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/get/{candidateId}/applications")
	public ResponseEntity<Object> getCandidateAppliedJobs(@PathVariable Long candidateId) {
		try {
			List<CandidateJobApplicationDetails> applicationDetails = candidateService.findCandidateById(candidateId)
					.getJobDetails();
			return new ResponseEntity<>(applicationDetails, HttpStatus.FOUND);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createCandidateProfile(@RequestBody CandidateRegistration registration) {
		try {
			String isCreated = candidateService.createCandidateProfile(registration);
			return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
		} catch (CandidateProfileAlreadyExistException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
