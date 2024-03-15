package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.PatientRequest;
import com.aaCode.ABC_backend.modal.Patient;
import com.aaCode.ABC_backend.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(path = "/addPatient")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequest patientRequest){
        Patient patient = patientService.createPatient(patientRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping(path = "/getAllPatients")
    public ResponseEntity<List<Patient>> getAllPatient(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }


}
