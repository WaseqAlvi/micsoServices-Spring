package com.company.Company.MicroService.Company;

import java.util.List;


public interface CompanyService {

    void createCompany(Company company);
    List<Company> allCompany();
    Company getCompanyById(long id);
    boolean editCompany(long id, Company company);
    boolean deleteCompany(long id);


}
