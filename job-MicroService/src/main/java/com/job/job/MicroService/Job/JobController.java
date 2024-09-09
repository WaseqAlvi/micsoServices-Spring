package com.job.job.MicroService.Job;

import com.job.job.MicroService.DTO.JobWithCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>>  findAll(){

        return  ResponseEntity.ok(jobService.findAll());
    }
    @GetMapping("/b")
    public ResponseEntity<List<Job>>  findJobByCompanyId(@RequestParam long companyId){

        return  ResponseEntity.ok(jobService.findJobByCompanyId(companyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobById(@PathVariable long id){

        JobWithCompanyDTO jobWithCompanyDTO=jobService.getJobById(id);

        if (jobWithCompanyDTO==null){
            return new ResponseEntity<>("Job Not Found",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(jobWithCompanyDTO);

    }
    @PostMapping("/createJob")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editJob(@PathVariable long id,@RequestBody Job job){

        boolean flag =jobService.editJob(id,job);
        if(flag){
            return new ResponseEntity<>(String.format("Job id %s edited" , id),HttpStatus.OK);
        }
        return new ResponseEntity<>(String.format("Job id %s not found" , id),HttpStatus.NOT_FOUND);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id){
        boolean flag=jobService.deleteJob(id);
        if (flag)
            return new ResponseEntity<>(String.format("Job id %s deleted", id),HttpStatus.ACCEPTED);
        return new ResponseEntity<>(String.format("Job id %s not found", id),HttpStatus.NOT_FOUND);
    }
}
