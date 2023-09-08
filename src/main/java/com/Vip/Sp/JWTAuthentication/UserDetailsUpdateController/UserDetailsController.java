package com.Vip.Sp.JWTAuthentication.UserDetailsUpdateController;

import com.Vip.Sp.JWTAuthentication.Models.CustomerDetails;
import com.Vip.Sp.JWTAuthentication.Models.ProviderDetails;
import com.Vip.Sp.JWTAuthentication.Services.UserService;
import com.Vip.Sp.Provider.Models.RequestAccept;
import com.Vip.Sp.Provider.Services.RequestAcceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserDetailsController {

    @Autowired
    private UserService userService;
    @PutMapping("/updateCustomerDetails")
    public ResponseEntity<String> updateCustomerDetails(
            @RequestBody CustomerDetails customerDetails,@RequestHeader("Authorization") String token) throws IOException {
        System.out.println(customerDetails);

        userService.updateCustomerDetails(customerDetails,token);
        return ResponseEntity.ok("Customer details updated successfully" );
    }

    @PutMapping("/updateProviderDetails")
    public ResponseEntity<String> updateProviderDetails(
            @RequestBody ProviderDetails providerDetails, @RequestHeader("Authorization") String token) throws IOException {

        userService.updateProviderDetails(providerDetails,token);
        return ResponseEntity.ok("Provider details updated successfully" );
    }

}
