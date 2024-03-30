package com.techm.project.dee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.Login;
import com.techm.project.dee.exception_handling.CandidateProfileAlreadyExistException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.repository.CandidateRepository;
import com.techm.project.dee.repository.LoginRepository;
import com.techm.project.dee.util.CandidateRegistration;
import com.techm.project.dee.util.RegistrationNumber;
import com.techm.project.dee.util.candidate_details.CandidateDetails;

@Service
public class CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	LoginRepository loginRepository;

	public CandidateDetails findCandidateById(Long candidateId) {
		CandidateDetails candidateDetails;
		if (candidateRepository.findById(candidateId).isPresent()) {
			Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
			if (candidate != null) {
				candidateDetails = CandidateDetails.setCandidateDetails(candidate);
			} else {
				throw new NotFoundException("ACcount Not Found");
			}
			return candidateDetails;
		} else {
			throw new NotFoundException("Account not found");
		}

	}

	public String createCandidateProfile(CandidateRegistration candidateRegistration) {
		if (candidateRepository.findByMobile(candidateRegistration.getMobile()).isPresent()) {
			throw new CandidateProfileAlreadyExistException("Account already exist by phone number");
		} else {
			Login login = loginRepository.findById((Long) candidateRegistration.getCandiateId()).orElse(null);
			if (candidateRepository.findByCandiateLoginId(login).isPresent()) {
				throw new CandidateProfileAlreadyExistException("Profile already created for this account");
			} else {
				if (login != null) {

					Candidate newCandidate = new Candidate();

					newCandidate.setFirstName(candidateRegistration.getFirstName());
					newCandidate.setLastName(candidateRegistration.getLastName());
					newCandidate.setDateOfBirth(candidateRegistration.getDateOfBirth());
					newCandidate.setMobile(candidateRegistration.getMobile());
					newCandidate.setGender(candidateRegistration.getGender());
					newCandidate.setRegistrationNumber(RegistrationNumber.generateRegistrationNumber());
					newCandidate.setCandiateLoginId(login);

					candidateRepository.save(newCandidate);
					return "Candidate Details Registered Successfully";
				} else {
					throw new NotFoundException("Account Not found");
				}
			}
		}
	}
}