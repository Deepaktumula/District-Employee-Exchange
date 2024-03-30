package com.techm.project.dee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@OneToOne
	@JoinColumn(nullable = false, name = "candidate_id", unique = true)
	@JsonBackReference
	private Candidate addressCandidateId;

	@Column(nullable = false, name = "street")
	private String street;

	@Column(nullable = false, name = "city")
	private String city;

	@Column(nullable = false, name = "district")
	private String district;

	@Column(nullable = false, name = "pincode")
	private String pinCode;

	@Column(nullable = false, name = "state")
	private String state;

	@Column(nullable = false, name = "country")
	private String country;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Long addressId, Candidate addressCandidateId, String street, String city, String district,
			String pinCode, String state, String country) {
		super();
		this.addressId = addressId;
		this.addressCandidateId = addressCandidateId;
		this.street = street;
		this.city = city;
		this.district = district;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Candidate getAddressCandidateId() {
		return addressCandidateId;
	}

	public void setAddressCandidateId(Candidate addressCandidateId) {
		this.addressCandidateId = addressCandidateId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
