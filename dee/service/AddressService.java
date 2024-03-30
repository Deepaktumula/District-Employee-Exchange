package com.techm.project.dee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.project.dee.entity.Address;
import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.exception_handling.DuplicateEntryException;
import com.techm.project.dee.exception_handling.NotFoundException;
import com.techm.project.dee.repository.AddressRepository;
import com.techm.project.dee.repository.CandidateRepository;
import com.techm.project.dee.util.CandidateAddress;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CandidateRepository candidateRepository;

	// Adding address
	public String addAddress(CandidateAddress candidateAddress) {
		Candidate candidate = candidateRepository.findById(candidateAddress.getCandidateId()).orElse(null);

		if (candidate != null) {

			if (addressRepository.findByAddressCandidateId(candidate).isPresent()) {
				throw new DuplicateEntryException("Address already exists for this candidateId");
			} else {

				Address address = new Address();
				address.setAddressCandidateId(candidate);
				address.setStreet(candidateAddress.getStreet());
				address.setCity(candidateAddress.getCity());
				address.setDistrict(candidateAddress.getDistrict());
				address.setCountry(candidateAddress.getCountry());
				address.setPinCode(candidateAddress.getPinCode());
				address.setState(candidateAddress.getState());
				address.setCountry(candidateAddress.getCountry());

				addressRepository.save(address);
				return "Address saved successfully";
			}
		} else {
			throw new NotFoundException("Candidate not found with this Id");
		}
	}

	public Optional<Address> getAddressByCandidateId(Long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
		if (candidate != null) {
			Optional<Address> address = addressRepository.findByAddressCandidateId(candidate);
			if (address.isPresent()) {
				return address;
			} else {
				throw new NotFoundException("Address not found/added for this candidateId");
			}
		} else {
			throw new NotFoundException("Candidate not found with this Id");
		}
	}

}
