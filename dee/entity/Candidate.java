package com.techm.project.dee.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Long candidateId;

	@OneToOne
	@JoinColumn(nullable = false, name = "login_id", unique = true)
	@JsonBackReference
	private Login candiateLoginId;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = false, name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(nullable = false, unique = true, name = "mobile_number")
	private String mobile;

	@Column(nullable = false, name = "gender")
	private String gender;

	@Column(nullable = false, name = "registration_number")
	private String registrationNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationCandidateId")
	@JsonManagedReference
	private List<Qualification> qualifications;

	@OneToOne(mappedBy = "addressCandidateId", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Address addressCandidateId;

	@OneToMany(mappedBy = "applicantId", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JobApplicants> applicants;

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public Candidate(Long candidateId, Login candiateLoginId, String firstName, String lastName, LocalDate dateOfBirth,
			String mobile, String gender, String registrationNumber) {
		super();
		this.candidateId = candidateId;
		this.candiateLoginId = candiateLoginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
		this.gender = gender;
		this.registrationNumber = registrationNumber;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Login getCandiateLoginId() {
		return candiateLoginId;
	}

	public void setCandiateLoginId(Login candiateLoginId) {
		this.candiateLoginId = candiateLoginId;
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

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Address getAddressCandidateId() {
		return addressCandidateId;
	}

	public void setAddressCandidateId(Address addressCandidateId) {
		this.addressCandidateId = addressCandidateId;
	}

	public List<JobApplicants> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<JobApplicants> applicants) {
		this.applicants = applicants;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candiateLoginId, candidateId, dateOfBirth, firstName, gender, lastName, mobile,
				registrationNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(candiateLoginId, other.candiateLoginId) && Objects.equals(candidateId, other.candidateId)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(registrationNumber, other.registrationNumber);
	}

}
