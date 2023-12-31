package com.Vip.Sp.JWTAuthentication.AuthController;


import com.Vip.Sp.JWTAuthentication.Configs.JWTservice;
import com.Vip.Sp.JWTAuthentication.DAOs.UserRepo;
import com.Vip.Sp.JWTAuthentication.Models.User;
import com.Vip.Sp.JWTAuthentication.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTservice jwTservice;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public  AuthenticationResponse register(RegisterRequest request) throws Exception {






        var user = User.builder()
                .userId(request.getUserId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .dob(request.getDob())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())



                .build();
        userRepo.save(user);


        var jwtToken = jwTservice.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepo.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwTservice.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken)

                .userId(user.getUserId())
                .role(user.getRole().name())
                .username(user.getFirstname())
                .expiredate(jwTservice.extractExpiration(jwtToken))
                .email(user.getEmail())
                .build();
    }


}
