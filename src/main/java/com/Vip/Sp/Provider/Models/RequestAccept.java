package com.Vip.Sp.Provider.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestAccept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long providerId;

    private String status;
    private Date acceptDate;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private String customerConfirmation;
    private String paidStatus;

}
