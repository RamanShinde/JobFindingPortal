package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.ApplicationDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Application;
import com.JobFindingPlatform.JobFindingPlatform.Enum.ApplicationStatus;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import com.JobFindingPlatform.JobFindingPlatform.Service.ApplicationService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/Application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("Apply")
    public ResponseEntity<String> apply(@RequestBody ApplicationDTO dto){
        return ResponseEntity.ok(applicationService.applyJob(dto));
    }
    @GetMapping("JobSeekerEmail/{jobSeekerEmail}")
    public ResponseEntity<List<ApplicationDTO>> getByJobseekerEmail(@PathVariable String jobSeekerEmail){
       return ResponseEntity.ok(applicationService.getByJobSeekerEmail(jobSeekerEmail));
    }
    @GetMapping("RecruiterEmail/{recruiterEmail}")
    public ResponseEntity<List<ApplicationDTO>> getByRecruiterEmail(@PathVariable String recruiterEmail){
        return ResponseEntity.ok(applicationService.getByJobSeekerEmail(recruiterEmail));
    }
    @GetMapping("JobTitle/{jobTitle}")
    public ResponseEntity<List<ApplicationDTO>> getByJobTitle(@PathVariable String jobTitle){
        return  ResponseEntity.ok(applicationService.getByJobTitle(jobTitle));
    }
    @GetMapping("JobId/{jobId}")
    public ResponseEntity<List<ApplicationDTO>> getByJobId(@PathVariable Long jobId){
        return ResponseEntity.ok(applicationService.getByJobId(jobId));
    }
    @GetMapping("JobType/{jobType}")
    public ResponseEntity<List<ApplicationDTO>> getJobType(@PathVariable JobType jobType){
        return ResponseEntity.ok(applicationService.getByJobType(jobType));
    }
    @
    PutMapping("UpdateStatus/{id}")
    public void updateStatus(@PathVariable Long id, @RequestBody ApplicationStatus status){
        applicationService.updateStatus(id,status);
    }

}
