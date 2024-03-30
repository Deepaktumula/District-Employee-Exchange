package com.techm.project.dee.util.candidate_details;

public class CandidateAddressDetails {
	
	private String street;
	private String city;
	private String district;
	private String pinCode;
	private String state;
	private String country;
	
	public CandidateAddressDetails() {
		// TODO Auto-generated constructor stub
	}

	public CandidateAddressDetails(String street, String city, String district, String pinCode, String state,
			String country) {
		super();
		this.street = street;
		this.city = city;
		this.district = district;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
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
