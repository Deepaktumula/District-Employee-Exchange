package com.techm.project.dee.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.project.dee.entity.Employer;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.InvalidCredentialsException;
import com.techm.project.dee.exception_handling.UpdatePasswordException;
import com.techm.project.dee.repository.EmployerRepository;
import com.techm.project.dee.util.UpdatePassword;

@Service
public class EmployerService {
	@Autowired
	EmployerRepository employerRepository;
	
	// Employer portal registration
	public String signUp(Employer employer) {
		if (employerRepository.findByEmail(employer.getEmail()).isPresent()) {
			throw new DuplicateEntryException("Account already exists");
		} else {
			employer.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
			employerRepository.save(employer);
			return "Employer registered successfully";
		}
	}

	// Employer portal login
	@Transactional
	public String validateCredentials(Employer employer) {
		if (employerRepository.findByEmailAndPassword(employer.getEmail(), employer.getPassword())
				.isPresent()) {
			employerRepository.updateLastLoginDate(employer.getEmail(), new Timestamp(System.currentTimeMillis()));
			return "Employer loggedIn successfully";
		} else {
			throw new InvalidCredentialsException("invalid credentials");
		}
	}

	// Employer portal password update
	@Transactional
	public String updatePassword(UpdatePassword updatePassword) {
		if (employerRepository.updatePassword(updatePassword.getNewPassword(), new Timestamp(System.currentTimeMillis()),
				updatePassword.getEmail(), updatePassword.getOldPassword()) > 0) {
			return "Password updated succcessfully";
		} else {
			throw new UpdatePasswordException("something went wrong!");
		}
	}
}
