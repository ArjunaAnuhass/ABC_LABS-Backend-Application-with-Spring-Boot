package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.TechnicianRequest;
import com.aaCode.ABC_backend.modal.Technician;
import com.aaCode.ABC_backend.service.technician.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/technician")
@CrossOrigin("*")
public class TechnicianController {

    private final TechnicianService technicianService;

    @Autowired
    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PostMapping(path = "/createTechnician")
    public ResponseEntity<Technician> createTechnician(@RequestBody TechnicianRequest technicianRequest){
        Technician technician = technicianService.createTechnician(technicianRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(technician);
    }

    @GetMapping(path = "/getAllTechnician")
    public ResponseEntity<List<Technician>> getAllTech(){
        return ResponseEntity.ok(technicianService.getAllTechnicians());
    }
}
