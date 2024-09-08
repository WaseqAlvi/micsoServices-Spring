package com.company.Company.MicroService.external;

import lombok.Data;

@Data
public class Job {
    private long id;
    private String title;
    private int salary;
    private long companyId;
}
