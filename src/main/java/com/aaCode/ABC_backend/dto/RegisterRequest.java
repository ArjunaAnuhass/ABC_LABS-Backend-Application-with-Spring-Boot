package com.aaCode.ABC_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
