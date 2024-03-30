package com.techm.project.dee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.project.dee.entity.Address;
import com.techm.project.dee.entity.Candidate;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByAddressCandidateId(Candidate candidate);

}
