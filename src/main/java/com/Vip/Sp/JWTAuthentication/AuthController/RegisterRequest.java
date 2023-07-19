package com.Vip.Sp.JWTAuthentication.AuthController;

import com.Vip.Sp.JWTAuthentication.Models.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder

public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String profession;
    private String gender;
    private Role role;
    private Date dob;
    private String phoneNumber;


}
