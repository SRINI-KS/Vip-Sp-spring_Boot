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
public class ProviderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String currentAddress;
    private  String country;
    private  String city;
    private  String state;
    private  Integer pinCode;
    private String[] profession;
    private Integer rating;

    public ProviderDetails(String currentAddress, String country, String city, String state, Integer pinCode, String[] profession, Integer rating) {
        this.currentAddress = currentAddress;
        this.country = country;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.profession = profession;
        this.rating = rating;
    }
}
