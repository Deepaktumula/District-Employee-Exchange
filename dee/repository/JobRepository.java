package com.techm.project.dee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.project.dee.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
	
	Optional<Job> findByTitle(String title);
	
	Optional<Job> findByJobCode(String jobCode);

}
