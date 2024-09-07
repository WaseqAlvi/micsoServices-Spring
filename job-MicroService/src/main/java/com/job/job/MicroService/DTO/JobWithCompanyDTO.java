package com.job.job.MicroService.DTO;

import com.job.job.MicroService.External.Company;
import com.job.job.MicroService.Job.Job;
import lombok.Data;

@Data
public class JobWithCompanyDTO {

    private long id;
    private String title;
    private int salary;


    private Company company;


}
