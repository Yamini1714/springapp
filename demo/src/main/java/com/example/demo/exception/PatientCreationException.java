package com.example.demo.exception;

public class PatientCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientCreationException(String message) {
        super(message);
    }

}
