package com.aaCode.ABC_backend.dto;

import com.aaCode.ABC_backend.modal.*;
import com.aaCode.ABC_backend.modal.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AddAppointmentRequest {

    private Long id;
    private Long doctorId;
    private Long patientId;
    private Long testId;
    private Integer userId;

    private LocalDateTime currentDateTime;
    private Date appointmentDateTime;
    private AppointmentStatus appointmentStatus;
    private Long price;


}
