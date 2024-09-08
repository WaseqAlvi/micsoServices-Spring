package com.company.Company.MicroService.Company;


import com.company.Company.MicroService.external.Job;
import com.company.Company.MicroService.external.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private long id;

    private String companyName;
    private String location;

    private ArrayList<Review> reviewList;
    private ArrayList<Job>jobList;








}
