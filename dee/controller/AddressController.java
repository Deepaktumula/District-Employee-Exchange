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

import com.techm.project.dee.entity.Address;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.service.AddressService;
import com.techm.project.dee.util.CandidateAddress;

@RestController
@RequestMapping("/candidate/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/create")
	public ResponseEntity<String> addAddress(@RequestBody CandidateAddress candidateAddress) {
		try {
			String isCreated = addressService.addAddress(candidateAddress);
			return ResponseEntity.status(HttpStatus.CREATED).body(isCreated);
		} catch (DuplicateEntryException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping("/getAddressesByCandidateId/{candidateId}")
	public ResponseEntity<Object> getAddressesByCandidateId(@PathVariable Long candidateId) {
		try {
			Optional<Address> addresses = addressService.getAddressByCandidateId(candidateId);
			return ResponseEntity.status(HttpStatus.OK).body(addresses);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
