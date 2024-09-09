package com.job.job.MicroService.Job;

import com.job.job.MicroService.DTO.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> findAll();

    List<Job> findJobByCompanyId(long companyId);
    void createJob(Job job);

    boolean editJob(long id,Job job);

    JobWithCompanyDTO getJobById(long id);

    boolean deleteJob(long id);
}
