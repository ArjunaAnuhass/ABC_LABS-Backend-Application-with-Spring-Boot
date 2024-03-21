package com.aaCode.ABC_backend.dto;

import lombok.Data;

@Data
public class ResultRequest {

    private Long id;
    private String testName;
    private String patientName;
    private String result;
    private String comment;
    private String appointmentName;
}
