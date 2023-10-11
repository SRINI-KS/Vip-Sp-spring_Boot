package com.Vip.Sp.JWTAuthentication.AuthController;

import com.Vip.Sp.Exception.ResponseFormat;
import com.Vip.Sp.JWTAuthentication.DAOs.GetUserRepo;
import com.Vip.Sp.JWTAuthentication.DAOs.UserRepo;
import com.Vip.Sp.JWTAuthentication.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:8100/"})
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private GetUserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest request) throws Exception {
        System.out.println(request.toString());
        List<User> isPresent = userRepo.findByEmail(request.getEmail());

        if(isPresent.isEmpty()){
            return ResponseFormat.responseBuilder("Account register success",HttpStatus.OK,authenticationService.register(request));
        }
        return ResponseFormat.responseBuilder("email already exists ,try new email", BAD_REQUEST,request);

    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequest request) {
        List<User> isPresent = userRepo.findByEmail(request.getEmail());
        System.out.println(isPresent.size());

        if(isPresent.isEmpty() || isPresent.size()>1){
            System.out.println("isPresent");
            return ResponseFormat.responseBuilder("User already exists", BAD_REQUEST,request);

        }
        else{
            return ResponseFormat.responseBuilder("Authentication success",HttpStatus.OK,authenticationService.authenticate(request));


        }

    }
}
