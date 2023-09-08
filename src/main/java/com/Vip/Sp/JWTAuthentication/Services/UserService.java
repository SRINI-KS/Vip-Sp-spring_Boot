package com.Vip.Sp.JWTAuthentication.Services;

import com.Vip.Sp.JWTAuthentication.DAOs.UserRepo;
import com.Vip.Sp.JWTAuthentication.Models.CustomerDetails;
import com.Vip.Sp.JWTAuthentication.Models.ProviderDetails;
import com.Vip.Sp.JWTAuthentication.Models.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GetUserDetails getUserDetails;

    public Boolean findByEmail(String email){
      var value=  this.userRepo.findByEmail(email);
        return value.isPresent();
    }

    public void updateCustomerDetails(CustomerDetails customerDetails, String token) {
        User userDetails=this.getUserDetails.getUserDetails(token);
        System.out.println(userDetails+"  user details");
        System.out.println(customerDetails+"  customer details");


        if (userDetails !=null){
            Set<CustomerDetails> customerDetailsSet =updateCustomer(customerDetails);
            System.out.println(customerDetailsSet+"  service");
            userDetails.setCustomerDetails(customerDetailsSet);
            userRepo.save(userDetails);
        }
        else {
            throw new EntityNotFoundException("CustomerDetails update failed");

        }
    }

    private Set<CustomerDetails> updateCustomer(CustomerDetails customerDetails) {
        System.out.println(customerDetails+" 111 update");

        Set<CustomerDetails> customerDetailsSet=new HashSet<>();
        CustomerDetails customer=new CustomerDetails(
                customerDetails.getAadharNumber(),
                customerDetails.getPanNumber(),
                customerDetails.getCurrentAddress(),
                customerDetails.getCountry(),
                customerDetails.getState(),
                customerDetails.getCity(),
                customerDetails.getPinCode()
                );
        customerDetailsSet.add(customer);
        System.out.println(customerDetailsSet+"  update");

        return customerDetailsSet;
    }


    public void updateProviderDetails(ProviderDetails providerDetails, String token) {

        User userDetails=this.getUserDetails.getUserDetails(token);

        if (userDetails !=null){
            Set<ProviderDetails> providerDetailsSet=updateProvider(providerDetails);
            userDetails.setProviderDetails(providerDetailsSet);
            userRepo.save(userDetails);
        }
        else {
            throw new EntityNotFoundException("CustomerDetails update failed");

        }
    }

    private Set<ProviderDetails> updateProvider(ProviderDetails providerDetails) {

        Set<ProviderDetails> providerDetailsSet=new HashSet<>();
        ProviderDetails provider=new ProviderDetails(
                providerDetails.getCurrentAddress(),
                providerDetails.getCountry(),
                providerDetails.getCity(),
                providerDetails.getState(),
                providerDetails.getPinCode(),
                providerDetails.getProfession(),
                providerDetails.getRating()
        );
        return providerDetailsSet;
    }
}
