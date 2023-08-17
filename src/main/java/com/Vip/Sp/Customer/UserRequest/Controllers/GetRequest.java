package com.Vip.Sp.Customer.UserRequest.Controllers;

import com.Vip.Sp.Customer.UserRequest.Entity.RequestModel;
import com.Vip.Sp.Customer.UserRequest.Services.RequestService;
import com.Vip.Sp.JWTAuthentication.Configs.JWTservice;
import com.Vip.Sp.JWTAuthentication.DAOs.GetUserRepo;
import com.Vip.Sp.JWTAuthentication.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class GetRequest {

    @Autowired
    private RequestService requestService;
    @Autowired
    private JWTservice jwTservice;

    @Autowired
    private GetUserRepo getUserRepo;

    @GetMapping("/getMyRequest")
    private List<RequestModel> getMyRequest(@RequestHeader("Authorization") String token) {
        String userEmail=null;
        List<User> userDetails=null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = null;
            jwt = token.substring(7);
            userEmail = jwTservice.extractUsername(jwt);
            userDetails=getUserRepo.findByEmail(userEmail);
            User user = userDetails.get(0);
            UUID userId = user.getUserId();
            System.out.println(userId);
             return this.requestService.getRequestByUserId(userId);
        }
        return Collections.emptyList();

    }
    @GetMapping("/getAllRequest")
    private List<RequestModel> getAllRequest(@RequestHeader("Authorization") String token) {


            return this.requestService.getAllRequest();
    }


}
