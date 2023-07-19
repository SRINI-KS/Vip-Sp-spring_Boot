package com.Vip.Sp.Customer.UserRequest.Entity;

import com.Vip.Sp.Image.Entity.ImageModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_request")
public class RequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private  String requestTitle;
    private  String   category;
    private  String  subCategory;
    private  String  requestDiscription;
    private  Integer fixedAmount;
    private  Integer minAmount;
    private  Integer maxAmount;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "request_images",
    joinColumns = {
            @JoinColumn(name = "request_id"),
    },
            inverseJoinColumns = {
            @JoinColumn(name="image_id")
    }
    )
    private Set<ImageModel> images;
    private  String payType;
    private Date startDate;
    private  Date endDate;
    private  String currentAddress;
    private  String country;
    private  String city;
    private  String state;
    private  Integer pinCode;
}
