package com.aaCode.ABC_backend.service.appointment;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import com.aaCode.ABC_backend.dto.AppointmentRequest;
import com.aaCode.ABC_backend.modal.Appointments;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface AppointmentService {

    public Appointments addAppointment(AppointmentRequest appointmentRequest);

    List<Appointments> getAllAppointment();

    public Appointments getAppointmentById(Long id);

    Appointments updateAppointment(Long id, Appointments appointments);

}