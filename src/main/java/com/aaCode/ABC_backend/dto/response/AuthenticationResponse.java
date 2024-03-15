package com.aaCode.ABC_backend.dto.response;

import com.aaCode.ABC_backend.modal.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
