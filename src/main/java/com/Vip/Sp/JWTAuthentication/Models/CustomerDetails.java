package com.Vip.Sp.JWTAuthentication.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aadharNumber;
    private String panNumber;
    private  String currentAddress;
    private  String country;
    private  String city;
    private  String state;
    private  Integer pinCode;

    public CustomerDetails(String aadharNumber, String panNumber, String currentAddress, String country, String city, String state, Integer pinCode) {
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.currentAddress = currentAddress;
        this.country = country;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }
}
