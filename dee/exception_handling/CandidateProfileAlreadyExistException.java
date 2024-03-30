package com.techm.project.dee.exception_handling;

public class CandidateProfileAlreadyExistException extends RuntimeException {
	public CandidateProfileAlreadyExistException(String message) {
		super(message);
	}
}
