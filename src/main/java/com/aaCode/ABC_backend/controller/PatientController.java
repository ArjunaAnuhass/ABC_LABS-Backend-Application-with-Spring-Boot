package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.PatientRequest;
import com.aaCode.ABC_backend.modal.Patient;
import com.aaCode.ABC_backend.modal.User;
import com.aaCode.ABC_backend.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patient")
@CrossOrigin("*")
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

    @GetMapping(path = "/getPatientById/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patient = patientService.getPatientById(id);

        if (patient != null){
            return ResponseEntity.ok(patient);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/updatePatient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @ModelAttribute Patient patient){
        Patient updatePatient = patientService.updatePatient(id, patient);

        if (updatePatient != null){
            return ResponseEntity.ok(updatePatient);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
