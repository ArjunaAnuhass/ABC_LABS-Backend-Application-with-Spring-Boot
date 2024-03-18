package com.aaCode.ABC_backend.dto;

import com.aaCode.ABC_backend.modal.Test;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@Data
public class AppointmentRequest {

    private Long id;
    private String appointmentName;
    private String patientName;
    private Date appointmentDate;
    private String testName;
    private UUID appointmentCode;
}
