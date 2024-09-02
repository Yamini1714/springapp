package com.example.demo.exception;

public class PatientUpdateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientUpdateException(String message) {
        super(message);
    }
}