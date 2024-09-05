package com.job.job.MicroService.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    boolean editJob(long id,Job job);

    Job getJobById(long id);

    boolean deleteJob(long id);
}
