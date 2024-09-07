package com.job.job.MicroService.Job;

import com.job.job.MicroService.DTO.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> findAll();
    void createJob(Job job);

    boolean editJob(long id,Job job);

    JobWithCompanyDTO getJobById(long id);

    boolean deleteJob(long id);
}
