package com.techm.project.dee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.Job;
import com.techm.project.dee.entity.JobApplicants;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplicants, Long> {
	boolean existsByApplicantIdAndJobID(Candidate candidate, Job job);
}
