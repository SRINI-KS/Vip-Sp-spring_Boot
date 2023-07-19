package com.Vip.Sp.Customer.UserRequest.DAOs;

import com.Vip.Sp.Customer.UserRequest.Entity.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestJpa extends JpaRepository<RequestModel,Long> {

    List<RequestModel> findByEmail(String userEmail);
}
