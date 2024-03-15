package com.aaCode.ABC_backend.service.patient;

import com.aaCode.ABC_backend.dto.PatientRequest;
import com.aaCode.ABC_backend.modal.Patient;
import com.aaCode.ABC_backend.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepo patientRepo;

    @Autowired
    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient createPatient(PatientRequest patientRequest){
        Patient patient = new Patient();

        patient.setFullname(patientRequest.getFullname());
        patient.setAddress(patientRequest.getAddress());
        patient.setEmail(patientRequest.getEmail());
        patient.setPhone(patientRequest.getPhone());
        patient.setDob(patientRequest.getDob());
        patient.setMedicalHistory(patientRequest.getMedicalHistory());
        patient.setPatientCode(patientRequest.getPatientCode());

        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }
}
