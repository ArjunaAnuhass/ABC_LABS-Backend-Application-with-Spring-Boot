package com.aaCode.ABC_backend.service.patient;

import com.aaCode.ABC_backend.dto.PatientRequest;
import com.aaCode.ABC_backend.modal.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient(PatientRequest patientRequest);

    List<Patient> getAllPatients();
}
