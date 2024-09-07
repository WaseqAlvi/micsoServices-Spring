package com.job.job.MicroService.External;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class Company {


    private long id;

    private String companyName;
    private String location;


}