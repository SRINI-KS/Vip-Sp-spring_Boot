package com.Vip.Sp.JWTAuthentication.AuthController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder

public class AuthenticationResponse {

    private String token;
    private String email;
    private Date expiredate;
    private String username;
    private String role;


}
