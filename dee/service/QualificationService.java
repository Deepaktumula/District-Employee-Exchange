package com.techm.project.dee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.Qualification;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.repository.CandidateRepository;
import com.techm.project.dee.repository.QualificationRepository;
import com.techm.project.dee.util.CandidateQualification;

@Service
public class QualificationService {
	@Autowired
	QualificationRepository qualificationRepository;

	@Autowired
	CandidateRepository candidateRepository;

	public String createQualification(CandidateQualification candidateQualification) {
		Candidate candidate = candidateRepository.findById(candidateQualification.getCandidateId()).orElse(null);

		if (candidate != null) {
			Boolean qualificationExistBoolean = false;
			for (Qualification qualification : candidate.getQualifications()) {
				if (qualification.getDegreeType().equals(candidateQualification.getDegreeType())) {
					qualificationExistBoolean = true;
				}
			}
			if (qualificationExistBoolean) {
				throw new DuplicateEntryException("Qualification already exist for this degree");
			} else {
				Qualification qualification = new Qualification();
				qualification.setQualificationCandidateId(candidate);
				qualification.setDegreeType(candidateQualification.getDegreeType());
				qualification.setUniversity(candidateQualification.getUniversity());
				qualification.setPercentage(candidateQualification.getPercentage());
				qualification.setPassOutYear(candidateQualification.getPassOutYear());

				qualificationRepository.save(qualification);
				return "Qualification added successfully";
			}
		} else {
			throw new NotFoundException("Candidate not found with this Id");
		}
	}

	public Optional<Qualification> getQualificationByCandidateId(Long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
		if (candidate != null) {
			Optional<Qualification> qualification = qualificationRepository.findByQualificationCandidateId(candidate);
			if (qualification.isPresent()) {
				return qualification;
			} else {
				throw new NotFoundException("Qualification not found/added for this candidateId");
			}
		} else {
			throw new NotFoundException("Candidate not found with this Id");
		}
	}
}
