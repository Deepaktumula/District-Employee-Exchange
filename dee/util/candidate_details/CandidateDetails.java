package com.techm.project.dee.util.candidate_details;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.techm.project.dee.entity.Candidate;
import com.techm.project.dee.entity.JobApplicants;
import com.techm.project.dee.entity.Qualification;

public class CandidateDetails {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String mobile;
	private String gender;
	private String registrationNumber;

	private CandidateAddressDetails addressDetails;

	private List<CandidateQualificationDetails> qualificationDetails;

	private List<CandidateJobApplicationDetails> jobDetails;

	public CandidateDetails() {
		// TODO Auto-generated constructor stub
	}

	public CandidateDetails(String firstName, String lastName, LocalDate dateOfBirth, String mobile, String gender,
			String registrationNumber, CandidateAddressDetails addressDetails,
			List<CandidateQualificationDetails> qualificationDetails, List<CandidateJobApplicationDetails> jobDetails) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
		this.gender = gender;
		this.registrationNumber = registrationNumber;
		this.addressDetails = addressDetails;
		this.qualificationDetails = qualificationDetails;
		this.jobDetails = jobDetails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public CandidateAddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(CandidateAddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public List<CandidateQualificationDetails> getQualificationDetails() {
		return qualificationDetails;
	}

	public void setQualificationDetails(List<CandidateQualificationDetails> qualificationDetails) {
		this.qualificationDetails = qualificationDetails;
	}

	public List<CandidateJobApplicationDetails> getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(List<CandidateJobApplicationDetails> jobDetails) {
		this.jobDetails = jobDetails;
	}

	public static CandidateDetails setCandidateDetails(Candidate candidate) {

		CandidateDetails details = new CandidateDetails();
		CandidateQualificationDetails qualificationDetails;
		CandidateJobApplicationDetails applicationDetails;
		CandidateAddressDetails addressDetails = new CandidateAddressDetails();

		List<CandidateQualificationDetails> qualifications = new ArrayList<>();

		List<CandidateJobApplicationDetails> applications = new ArrayList<>();

		for (Qualification qualification : candidate.getQualifications()) {

			qualificationDetails = new CandidateQualificationDetails();

			qualificationDetails.setUniversity(qualification.getUniversity());
			qualificationDetails.setDegreeType(qualification.getDegreeType());
			qualificationDetails.setPassOutYear(qualification.getPassOutYear());
			qualificationDetails.setPercentage(qualification.getPercentage());

			qualifications.add(qualificationDetails);

		}

		for (JobApplicants applicants : candidate.getApplicants()) {

			applicationDetails = new CandidateJobApplicationDetails();

			applicationDetails.setApplicationCode(applicants.getApplicationCode());
			applicationDetails.setAppliedDate(applicants.getAppliedDate());
			applicationDetails.setStatus(applicants.getStatus());
			
			CandidateJobDetails jobDetails = new CandidateJobDetails();
			
			jobDetails.setJobCode(applicants.getJobID().getJobCode());
			jobDetails.setTitle(applicants.getJobID().getTitle());
			jobDetails.setCategory(applicants.getJobID().getCategory());
			jobDetails.setResponsibilities(applicants.getJobID().getResponsibilities());
			jobDetails.setSalary(applicants.getJobID().getSalary());
			jobDetails.setJobLocation(applicants.getJobID().getJobLocation());
			
			applicationDetails.setJobDetails(jobDetails);
			
			applications.add(applicationDetails);

		}
		
		addressDetails.setStreet(candidate.getAddressCandidateId().getStreet());
		addressDetails.setPinCode(candidate.getAddressCandidateId().getPinCode());
		addressDetails.setCity(candidate.getAddressCandidateId().getCity());
		addressDetails.setDistrict(candidate.getAddressCandidateId().getDistrict());
		addressDetails.setState(candidate.getAddressCandidateId().getState());
		addressDetails.setCountry(candidate.getAddressCandidateId().getCountry());
		
		details.setFirstName(candidate.getFirstName());
		details.setLastName(candidate.getLastName());
		details.setMobile(candidate.getMobile());
		details.setRegistrationNumber(candidate.getRegistrationNumber());
		details.setDateOfBirth(candidate.getDateOfBirth());
		details.setGender(candidate.getGender());
		details.setAddressDetails(addressDetails);
		details.setQualificationDetails(qualifications);
		details.setJobDetails(applications);
		
		return details;

	}

}
