package com.techm.project.dee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.project.dee.entity.Qualification;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.service.QualificationService;
import com.techm.project.dee.util.CandidateQualification;

@RestController
@RequestMapping("/qualification")
public class QualificationController {
	@Autowired
	QualificationService qualificationService;
	
	// Creating the Qualification
	@PostMapping("/create")
	public ResponseEntity<String> createQualification(@RequestBody CandidateQualification candidateQualification) {
		try {
			String isCreated = qualificationService.createQualification(candidateQualification);
			return ResponseEntity.status(HttpStatus.CREATED).body(isCreated);
		} catch (DuplicateEntryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	// Getting qualification by candidateId
	@GetMapping("/getQualificationByCandidateId/{candidateId}")
	public ResponseEntity<Object> getQualificationByCandidateId(@PathVariable Long candidateId) {
		try {
			Optional<Qualification> qualification = qualificationService.getQualificationByCandidateId(candidateId);
			return ResponseEntity.status(HttpStatus.OK).body(qualification);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
