package com.Vip.Sp.YR_Ionic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service_Details")
public class ServiceDetailsModel {
    @Id
    private Long id;
    private String serviceName;
    private String image;
//    private Details details;

    // Getters and setters
    // Constructors
    // Other methods

//    public static class Details {
//        private String category;
//        private String subCategory;
//        private String description;
//        private List<String> customIssue;

        // Getters and setters
        // Constructors
        // Other meth
  //  }
}
