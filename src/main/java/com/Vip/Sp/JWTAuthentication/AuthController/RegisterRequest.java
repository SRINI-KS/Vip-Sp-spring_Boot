package com.Vip.Sp.JWTAuthentication.AuthController;

import com.Vip.Sp.JWTAuthentication.Models.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder

public class RegisterRequest {

    private UUID userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String gender;
    private Role role;
    private Date dob;
    private String phoneNumber;


}
