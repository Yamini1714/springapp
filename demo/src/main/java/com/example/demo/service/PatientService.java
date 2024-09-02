package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PatientCreationException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    
    private PatientRepository PatientRepository;

    public List<Patient> getAllPatients() {
        return PatientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
       return PatientRepository.findById(id);
    }
    
    public Patient createPatient(Patient patient) {
        try {
           return PatientRepository.save(patient);
        } catch (Exception e) {
            throw new PatientCreationException("Failed to create patient: " + e.getMessage());
        }
	
    }
    

    //public Patient createPatient(Patient Patient) {
    //   return PatientRepository.save(Patient);
    //}

    public Patient updatePatient(Long id, Patient PatientDetails) {
        Patient Patient = PatientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        Patient.setFirstName(PatientDetails.getFirstName());
        Patient.setLastName(PatientDetails.getLastName());
        Patient.setAge(PatientDetails.getAge());
        Patient.setGender(PatientDetails.getGender());
        Patient.setPhoneNumber(PatientDetails.getPhoneNumber());
        Patient.setAddress(PatientDetails.getAddress());
        Patient.setDisability(PatientDetails.getDisability());

        return PatientRepository.save(Patient);
    }

    public void deletePatient(Long id) {
        Patient Patient = PatientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        PatientRepository.delete(Patient);
    }
}
