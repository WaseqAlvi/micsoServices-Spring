package com.job.job.MicroService.openFeignClient;

import com.job.job.MicroService.External.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(name = "COMPANY-MICROSERVICE")
public interface CompanyClient {

    @GetMapping("/company/{id}")
     Company getCompanyByIds(@PathVariable("id") long companyId);
}
