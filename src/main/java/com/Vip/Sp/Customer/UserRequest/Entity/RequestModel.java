package com.Vip.Sp.Customer.UserRequest.Entity;

import com.Vip.Sp.Image.Entity.ImageModel;
import com.Vip.Sp.Provider.Models.RequestAccept;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_request")
public class RequestModel {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    private UUID userId;
    private  String requestTitle;
    private  String  category;
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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "Request_AcceptDetails",
            joinColumns = {
                    @JoinColumn(name = "Request_Id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name="RequestAccept_Id")
            }
    )
    private Set<RequestAccept> AcceptDetails;


    public void updateAcceptDetailsStatus(String newStatus) {
        for (RequestAccept acceptDetail : AcceptDetails) {
            acceptDetail.setCustomerConfirmation(newStatus);
        }
    }


}
