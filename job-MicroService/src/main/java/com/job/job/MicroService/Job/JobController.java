package com.job.job.MicroService.Job;

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
    public ResponseEntity<List<Job>>  findAll(){

        return  ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobById(@PathVariable long id){

        Job job=jobService.getJobById(id);

        if (job==null){
            return new ResponseEntity<>("Job Not Found",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(job);

    }
    @PostMapping
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
