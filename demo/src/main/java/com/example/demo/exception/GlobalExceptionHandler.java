package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFoundException(PatientNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            "The requested patient ID does not exist",
            "PATIENT_NOT_FOUND"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientCreationException.class)
    public ResponseEntity<ErrorResponse> handlePatientCreationException(PatientCreationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            "Error occurred while creating the patient",
            "PATIENT_CREATION_ERROR"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PatientUpdateException.class)
    public ResponseEntity<ErrorResponse> handlePatientUpdateException(PatientUpdateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            "Error occurred while updating the patient",
            "PATIENT_UPDATE_ERROR"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
