package com.Vip.Sp.Provider.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestAccept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID customerId;
    private UUID providerId;
    private String status;
    private Date acceptDate;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private String customerConfirmation;
    private String paidStatus;
    private int amountPaid;


    public RequestAccept(UUID customerId, UUID providerId, String status, Date acceptDate, Date serviceStartDate, Date serviceEndDate, String customerConfirmation, String paidStatus) {
        this.customerId = customerId;
        this.providerId = providerId;
        this.status = status;
        this.acceptDate = acceptDate;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
        this.customerConfirmation = customerConfirmation;
        this.paidStatus = paidStatus;
    }
}


