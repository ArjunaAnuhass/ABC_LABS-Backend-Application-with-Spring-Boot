package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.dto.AppointmentRequest;
import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.Appointments;
import com.aaCode.ABC_backend.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/appointment")
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
}
