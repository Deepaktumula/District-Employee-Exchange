package com.techm.project.dee.entity;

import java.time.Year;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualification")
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qualification_id")
	private Long qualificationId;

	@ManyToOne
	@JoinColumn(nullable = false, name = "candidate_id")
	@JsonBackReference
	private Candidate qualificationCandidateId;

	@Column(nullable = false, name = "degree_type")
	private String degreeType;

	@Column(nullable = false, name = "university")
	private String university;

	@Column(nullable = false, name = "pass_out_year")
	private Year passOutYear;

	@Column(nullable = false, name = "percentage")
	private Double percentage;

	public Qualification() {
		// TODO Auto-generated constructor stub
	}

	public Qualification(Long qualificationId, Candidate qualificationCandidateId, String degreeType, String university,
			Year passOutYear, Double percentage) {
		super();
		this.qualificationId = qualificationId;
		this.qualificationCandidateId = qualificationCandidateId;
		this.degreeType = degreeType;
		this.university = university;
		this.passOutYear = passOutYear;
		this.percentage = percentage;
	}

	public Long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Candidate getQualificationCandidateId() {
		return qualificationCandidateId;
	}

	public void setQualificationCandidateId(Candidate qualificationCandidateId) {
		this.qualificationCandidateId = qualificationCandidateId;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Year getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(Year passOutYear) {
		this.passOutYear = passOutYear;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(degreeType, passOutYear, percentage, qualificationCandidateId, qualificationId, university);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Qualification other = (Qualification) obj;
		return Objects.equals(degreeType, other.degreeType) && Objects.equals(passOutYear, other.passOutYear)
				&& Objects.equals(percentage, other.percentage)
				&& Objects.equals(qualificationCandidateId, other.qualificationCandidateId)
				&& Objects.equals(qualificationId, other.qualificationId)
				&& Objects.equals(university, other.university);
	}

}
