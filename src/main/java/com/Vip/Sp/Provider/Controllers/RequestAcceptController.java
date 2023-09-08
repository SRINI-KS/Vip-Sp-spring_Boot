package com.Vip.Sp.Provider.Controllers;

import com.Vip.Sp.Exception.ResponseFormat;
import com.Vip.Sp.JWTAuthentication.AuthController.RegisterRequest;
import com.Vip.Sp.JWTAuthentication.Models.User;
import com.Vip.Sp.Provider.Models.RequestAccept;
import com.Vip.Sp.Provider.Services.RequestAcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class RequestAcceptController {

    @Autowired
    private RequestAcceptService requestAcceptService;
    @PutMapping("/requestAccept/{requestId}")
    public ResponseEntity<String> updateOrderAccepts(
            @PathVariable("requestId") Long requestId,
            @RequestBody RequestAccept requestAccept) throws IOException {
        System.out.println(requestAccept);

        requestAcceptService.updateAcceptsInOrder(requestId, requestAccept);
        return ResponseEntity.ok("Accepts updated successfully for Order ID: " + requestId);
    }

    @PutMapping("/updateCustomerApproval/{requestId}")
    public ResponseEntity<String> updateCustomerApproval(
            @PathVariable("requestId") Long requestId,
            @RequestBody String approvalStatus ) throws IOException {
System.out.println(approvalStatus+"   bruhh");
        requestAcceptService.updateCustomerApproval(requestId,approvalStatus);
        return ResponseEntity.ok("Accepted the Service Provider" + requestId);
    }
}
