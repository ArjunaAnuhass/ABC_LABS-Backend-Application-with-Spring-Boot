package com.aaCode.ABC_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PatientRequest {

    private Long id;

    private String fullname;
    private String address;
    private String email;
    private String phone;
    private Date dob;
    private String medicalHistory;
    private String patientCode;
}
