package com.aaCode.ABC_backend.service.appointment;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.dto.AppointmentRequest;
import com.aaCode.ABC_backend.modal.Appointments;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface AppointmentService {

    public Appointments addAppointment(AppointmentRequest appointmentRequest);

}