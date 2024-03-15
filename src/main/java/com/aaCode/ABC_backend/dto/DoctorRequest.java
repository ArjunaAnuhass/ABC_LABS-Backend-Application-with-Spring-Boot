package com.aaCode.ABC_backend.dto;

import lombok.Data;

@Data
public class DoctorRequest {

    private Long id;

    private String fullname;
    private String email;
    private String phone;
    private String specialization;
}
