package com.techm.project.dee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.Login;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	Optional<Candidate> findByMobile(String mobile);

	Optional<Candidate> findByCandiateLoginId(Login login);
}
