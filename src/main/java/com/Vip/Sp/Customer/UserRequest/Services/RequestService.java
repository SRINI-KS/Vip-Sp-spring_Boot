package com.Vip.Sp.Customer.UserRequest.Services;


import com.Vip.Sp.Customer.UserRequest.DAOs.RequestJpa;
import com.Vip.Sp.Customer.UserRequest.Entity.RequestModel;
import com.Vip.Sp.JWTAuthentication.Configs.JWTservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RequestService {

    @Autowired
    private RequestJpa requestJpa;
    @Autowired
    private JWTservice jwTservice;




    public RequestModel addRequest(RequestModel request){
        return this.requestJpa.save(request);
    }

    public List<RequestModel> getAllRequest(){

        return this.requestJpa.findAll();
    }

    public List<RequestModel> getRequestByUserId(UUID userId) {
        return this.requestJpa.findByUserId(userId);
    }
}
