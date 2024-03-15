package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(path = "/addAppointment")
    public ResponseEntity<Void> AddAppointment(@RequestBody AddAppointmentRequest addAppointmentRequest){
        boolean success = appointmentService.makeAppointment(addAppointmentRequest);

        if (success)
            return ResponseEntity.status(HttpStatus.CREATED).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
