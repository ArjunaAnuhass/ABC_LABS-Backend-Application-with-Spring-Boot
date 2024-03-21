package com.aaCode.ABC_backend.controller;

import com.aaCode.ABC_backend.dto.AuthenticationRequest;
import com.aaCode.ABC_backend.dto.response.AuthenticationResponse;
import com.aaCode.ABC_backend.dto.RegisterRequest;
import com.aaCode.ABC_backend.modal.User;
import com.aaCode.ABC_backend.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/authentication")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "/register1")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(authenticationService.registerUser(request));
    }

    @PostMapping(path ="/register2")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping(path = "/register3")
    public ResponseEntity<AuthenticationResponse> registerTechnician(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registerTechnician(request));
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(authenticationService.getAllUsers());
    }
}
