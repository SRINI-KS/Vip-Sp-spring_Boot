package com.Vip.Sp.JWTAuthentication.DAOs;

import com.Vip.Sp.JWTAuthentication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

        Optional<User> findByEmail(String email);


}
