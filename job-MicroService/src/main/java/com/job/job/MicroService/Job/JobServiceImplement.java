package com.job.job.MicroService.Job;

import com.job.job.MicroService.AppConfig;
import com.job.job.MicroService.DTO.JobWithCompanyDTO;
import com.job.job.MicroService.External.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class JobServiceImplement implements JobService {

    public ArrayList<Job> lists = new ArrayList<>();


    @Autowired
    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job> allJobs=jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOList=new ArrayList<>();
        return allJobs.stream().map(this::jobWithCompanyDTOConverter).collect(Collectors.toList());
    }

    private JobWithCompanyDTO jobWithCompanyDTOConverter(Job job){

        JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
        Company company=restTemplate.getForObject("http://COMPANY-MICROSERVICE:8082/company/"+job.getCompanyId(), Company.class);
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setSalary(job.getSalary());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setId(job.getId());
        return jobWithCompanyDTO;
    }

    @Override
    public void createJob(Job job) {

        jobRepository.save(job);
    }

    @Override
    public boolean editJob(long id, Job job) {

        boolean flag = jobRepository.existsById(id);
        if (flag) {
            job.setId(id);
            jobRepository.save(job);
            return true;
        }
        return false;

    }

    @Override
    public JobWithCompanyDTO getJobById(long id) {


        Job job=jobRepository.findById(id).orElse(null);
        if(job==null)
            return null;
        return jobWithCompanyDTOConverter(job);
    }


    @Override
    public boolean deleteJob(long id) {

        boolean flag = jobRepository.existsById(id);
        if (flag) {

            jobRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
