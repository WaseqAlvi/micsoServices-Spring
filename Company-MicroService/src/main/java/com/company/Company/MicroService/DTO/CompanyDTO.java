package com.company.Company.MicroService.DTO;


import com.company.Company.MicroService.external.Job;
import com.company.Company.MicroService.external.Review;
import lombok.Data;

import java.util.List;
@Data
public class CompanyDTO {


    private long id;

    private String companyName;
    private String location;

    private List<Review> reviewList;
    private List<Job> jobList;






}
