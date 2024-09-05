package com.company.Company.MicroService.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> allCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
       return companyRepository.findById(id).orElse(null);



    }

    @Override
    public boolean editCompany(long id, Company company) {
        Company company1=companyRepository.findById(id).orElse(null);
        if(company1==null){
            return false;

        }
        company.setId(id);
        companyRepository.save(company);
        return true;

    }

    @Override
    public boolean deleteCompany(long id) {

        Company company1=companyRepository.findById(id).orElse(null);

        if(company1==null){
            return false;
        }

        companyRepository.deleteById(id);

        return true;
    }
}
