package com.techm.project.dee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

	Optional<Qualification> findByQualificationCandidateId(Candidate candidate);
	
	Optional<Qualification> findByDegreeType(String degree);
}
