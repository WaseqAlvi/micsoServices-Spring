package com.company.Company.MicroService.Company;

import com.company.Company.MicroService.DTO.CompanyDTO;

import java.util.List;


public interface CompanyService {

    void createCompany(Company company);
    List<Company> allCompany();
    CompanyDTO getCompanyById(long id);
    boolean editCompany(long id, Company company);
    boolean deleteCompany(long id);


}
