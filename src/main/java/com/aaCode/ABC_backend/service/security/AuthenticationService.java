package com.aaCode.ABC_backend.service.security;

import com.aaCode.ABC_backend.dto.AuthenticationRequest;
import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.dto.response.AuthenticationResponse;
import com.aaCode.ABC_backend.dto.RegisterRequest;
import com.aaCode.ABC_backend.modal.Test;
import com.aaCode.ABC_backend.repository.UserRepo;
import com.aaCode.ABC_backend.modal.enums.Role;
import com.aaCode.ABC_backend.modal.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;



    public AuthenticationResponse registerUser(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        userRepo.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .id(user.getId())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }


    public AuthenticationResponse registerTechnician(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.TECHNICIAN)
                .build();
        userRepo.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public RegisterRequest getUserById(Integer id){
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()){
            return optionalUser.get().getUserDto();
        }
        else {
            return null;
        }
    }

    public RegisterRequest updateUser(Integer id, RegisterRequest registerRequest){
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setFirstname(registerRequest.getFirstname());
            user.setLastname(registerRequest.getLastname());
            user.setEmail(registerRequest.getEmail());

            return userRepo.save(user).getUserDto();
        }
        else {
            return null;
        }
    }
}
