package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.DoctorRequest;
import com.aaCode.ABC_backend.modal.Doctor;
import com.aaCode.ABC_backend.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping(path = "/addDcotor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody DoctorRequest doctorRequest){
        Doctor doctor = doctorService.createDoctor(doctorRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    @GetMapping(path = "/getAllDoctors")
    public ResponseEntity<List<Doctor>> getAllDoc(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
}
