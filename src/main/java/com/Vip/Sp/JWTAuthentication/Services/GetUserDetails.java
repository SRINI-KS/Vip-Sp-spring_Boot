package com.Vip.Sp.JWTAuthentication.Services;

import com.Vip.Sp.JWTAuthentication.Configs.JWTservice;
import com.Vip.Sp.JWTAuthentication.DAOs.GetUserRepo;
import com.Vip.Sp.JWTAuthentication.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.UUID;
@Component
public class GetUserDetails {
    @Autowired
    private JWTservice jwTservice;
    @Autowired
    private GetUserRepo getUserRepo;
    public User getUserDetails( String token){
        String userEmail=null;
        List<User> userDetails=null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = null;
            jwt = token.substring(7);
            userEmail = jwTservice.extractUsername(jwt);
            userDetails=getUserRepo.findByEmail(userEmail);
            return userDetails.get(0);
        }

        return null;
    }
}
