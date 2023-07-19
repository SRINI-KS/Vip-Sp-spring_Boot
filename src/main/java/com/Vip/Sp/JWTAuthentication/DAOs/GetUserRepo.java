package com.Vip.Sp.JWTAuthentication.DAOs;

import com.Vip.Sp.JWTAuthentication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetUserRepo extends JpaRepository<User,Long> {
    List<User> findByEmail(String emial);
}
