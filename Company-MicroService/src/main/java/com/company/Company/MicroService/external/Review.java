package com.company.Company.MicroService.external;

import lombok.Data;

@Data
public class Review {
    private long id;
    private String description;
    private double rating;
    private long companyId;
}
