package com.aaCode.ABC_backend.service.patient;

import com.aaCode.ABC_backend.dto.PatientRequest;
import com.aaCode.ABC_backend.modal.Patient;
import com.aaCode.ABC_backend.modal.User;
import com.aaCode.ABC_backend.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        patient.setPatientCode(UUID.randomUUID());

        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public Patient getPatientById(Long id){
        Optional<Patient> optionalPatient = patientRepo.findById(id);

        if (optionalPatient.isPresent()){
            return optionalPatient.get();
        }
        else {
            return null;
        }
    }

    public Patient updatePatient(Long id, Patient patient){
        Optional<Patient> optionalPatient = patientRepo.findById(id);

        if (optionalPatient.isPresent()){
            Patient patient1 = optionalPatient.get();

            patient1.setFullname(patient.getFullname());
            patient1.setAddress(patient.getAddress());
            patient1.setEmail(patient.getEmail());
            patient1.setPhone(patient.getPhone());
            patient1.setMedicalHistory(patient.getMedicalHistory());

            return patientRepo.save(patient1);
        }
        else {
            return null;
        }
    }
}
