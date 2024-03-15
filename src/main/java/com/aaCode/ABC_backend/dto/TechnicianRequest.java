package com.aaCode.ABC_backend.dto;

import lombok.Data;

@Data
public class TechnicianRequest {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String specialization;
}
