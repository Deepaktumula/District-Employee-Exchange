package com.techm.project.dee.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.project.dee.entity.Login;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.InvalidCredentialsException;
import com.techm.project.dee.exception_handling.UpdatePasswordException;
import com.techm.project.dee.repository.LoginRepository;
import com.techm.project.dee.util.CandidateLogin;
import com.techm.project.dee.util.CandidateSignUp;
import com.techm.project.dee.util.UpdatePassword;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	// Candidate portal registration
	public String signUp(CandidateSignUp candidateRegistration) {
		if (loginRepository.findByEmail(candidateRegistration.getEmail()).isPresent()) {
			throw new DuplicateEntryException("Account already exists");
		} else {
			Login login = new Login();
			login.setEmail(candidateRegistration.getEmail());
			login.setPassword(candidateRegistration.getPassword());
			login.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
			loginRepository.save(login);
			return "User registered successfully";
		}
	}

	// Candidate portal login
	@Transactional
	public String validateCredentials(CandidateLogin candidateLogin) {
		if (loginRepository.findByEmailAndPassword(candidateLogin.getEmail(), candidateLogin.getPassword())
				.isPresent()) {
			loginRepository.updateLastLoginDate(candidateLogin.getEmail(), new Timestamp(System.currentTimeMillis()));
			return "Login successfully";
		} else {
			throw new InvalidCredentialsException("invalid credentials");
		}
	}

	// Candidate portal password update
	@Transactional
	public String updatePassword(UpdatePassword updatePassword) {
		if (loginRepository.updatePassword(updatePassword.getNewPassword(), new Timestamp(System.currentTimeMillis()),
				updatePassword.getEmail(), updatePassword.getOldPassword()) > 0) {
			return "Password updated succcessfully";
		} else {
			throw new UpdatePasswordException("something went wrong!");
		}
	}
}
