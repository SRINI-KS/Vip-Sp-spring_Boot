package com.Vip.Sp.JWTAuthentication.AuthController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AuthenticationRequest {

    String password;
    private String email;


}
