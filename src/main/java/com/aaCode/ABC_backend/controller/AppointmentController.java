package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.AppointmentRequest;
import com.aaCode.ABC_backend.modal.Appointments;
import com.aaCode.ABC_backend.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appointment")
@CrossOrigin("*")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

//    @PostMapping(path = "/addAppointment")
//    public ResponseEntity<AddAppointmentRequest> AddAppointment(@ModelAttribute AddAppointmentRequest addAppointmentRequest) {
//        AddAppointmentRequest addAppointmentRequest1 = appointmentService.makeAppointment(addAppointmentRequest);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(addAppointmentRequest1);
//    }


    @PostMapping(path = "/addAppointment")
    public ResponseEntity<Appointments> addTest(@RequestBody AppointmentRequest appointmentRequest){
        Appointments appointments = appointmentService.addAppointment(appointmentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(appointments);
    }

    @GetMapping(path = "/getAllAppointments")
    public ResponseEntity<List<Appointments>> getAllApp(){
        return ResponseEntity.ok(appointmentService.getAllAppointment());
    }

    @GetMapping(path = "/getAppointmentById/{id}")
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable Long id){
        Appointments appointments = appointmentService.getAppointmentById(id);

        if (appointments != null){
            return ResponseEntity.ok(appointments);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/updateAppointment/{id}")
    public ResponseEntity<Appointments> updateTest(@PathVariable Long id, @ModelAttribute Appointments appointments){
        Appointments updateAppointment = appointmentService.updateAppointment(id, appointments);

        if (updateAppointment != null){
            return ResponseEntity.ok(updateAppointment);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/searchAppointment/{appointmentName}")
    public ResponseEntity<List<String>> getAllAppointmentsByName(@PathVariable String appointmentName){
        List<String> appointments =appointmentService.getAllAppointmentsByAppointmentName(appointmentName);

        return ResponseEntity.ok(appointments);
    }
}
