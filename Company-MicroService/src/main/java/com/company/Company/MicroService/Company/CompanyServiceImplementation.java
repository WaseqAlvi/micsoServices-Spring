package com.company.Company.MicroService.Company;

import com.company.Company.MicroService.DTO.CompanyDTO;
import com.company.Company.MicroService.external.Job;
import com.company.Company.MicroService.external.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public List<CompanyDTO> allCompany() {
        List<CompanyDTO> companyList=new ArrayList<>();

        for(Company company:companyRepository.findAll()){

            companyList.add(convertCompanyDTO(company));
        }

        return companyList;
    }

    @Override
    public CompanyDTO getCompanyById(long id) {


        Company company= companyRepository.findById(id).orElse(null);
        if (company==null){
            return null;
        }
        return convertCompanyDTO(company);

    }

    private CompanyDTO convertCompanyDTO(Company company){
          ResponseEntity<List<Review>> ReviewListResponseEntity= restTemplate.exchange(
                "http://REVIEW-MICROSERVICE:8083/reviews?companyId=" + company.getId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {}
        );
        List<Review> reviewList = ReviewListResponseEntity.getBody();

        ResponseEntity<List<Job>> jobListResponseEntity= restTemplate.exchange(
                "http://JOB-MICROSERVICE:8085/jobs/b?companyId="+company.getId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Job>>() {}
        );
        List<Job> jobList = jobListResponseEntity.getBody();
        CompanyDTO companyDTO=new CompanyDTO();
       companyDTO.setJobList(jobList);
        companyDTO.setReviewList(reviewList);
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setLocation(company.getLocation());
        companyDTO.setId(company.getId());
        return companyDTO;
    }
    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
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
