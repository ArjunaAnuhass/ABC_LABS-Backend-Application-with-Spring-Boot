package com.aaCode.ABC_backend.service.appointment;

import com.aaCode.ABC_backend.dto.AddAppointmentRequest;
import org.springframework.http.ResponseEntity;

public interface AppointmentService {

    boolean makeAppointment(AddAppointmentRequest addAppointmentRequest);

}