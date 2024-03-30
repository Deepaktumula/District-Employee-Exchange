package com.techm.project.dee.exception_handling;

public class EmailAlreadyExistException extends RuntimeException {
	public EmailAlreadyExistException(String message) {
		super(message);
	}
}
