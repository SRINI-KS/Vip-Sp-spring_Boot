package com.Vip.Sp.JWTAuthentication.Services;

import com.Vip.Sp.JWTAuthentication.DAOs.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Boolean findByEmail(String email){
      var value=  this.userRepo.findByEmail(email);
      if(value !=null){
          return true;
      }
      return false;
    }

}
