package com.job.job.MicroService.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service

public class JobServiceImplement implements JobService {

    public ArrayList<Job> lists = new ArrayList<>();
    @Autowired
    JobRepository jobRepository;


    @Override
    public List<Job> findAll() {
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getForObject()
        return jobRepository.findAll();
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
    public Job getJobById(long id) {

        return jobRepository.findById(id).orElse(null);
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
