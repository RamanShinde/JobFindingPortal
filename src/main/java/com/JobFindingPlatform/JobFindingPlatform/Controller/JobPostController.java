package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.JobPostDTO;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import com.JobFindingPlatform.JobFindingPlatform.Service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/JobPost")
public class JobPostController {
    @Autowired
    JobPostService jobPostService;

    @PostMapping("Create")
    public ResponseEntity<String> createJobPost(@RequestBody JobPostDTO dto){
        return ResponseEntity.ok(jobPostService.createJobPost(dto));
    }

    @GetMapping("CompanyName/{companyName}")
    public ResponseEntity<List<JobPostDTO>> getByCompanyName( @PathVariable String companyName){
        return ResponseEntity.ok(jobPostService.getByCompanyName(companyName));
    }
    @GetMapping("PostBy/{postBy}")
    public  ResponseEntity<List<JobPostDTO>> getByPostedBy(@PathVariable String postBy){
        return  ResponseEntity.ok(jobPostService.getByPostedBy(postBy));
    }
    @GetMapping("jobTitle/{jobTitle}")
    public ResponseEntity<List<JobPostDTO>> getByJobTitle(@PathVariable String jobtitle){
        return  ResponseEntity.ok(jobPostService.getByJobTitle(jobtitle));
    }
    @GetMapping("jobType/{jobType}")
    public  ResponseEntity<List<JobPostDTO>> getByJobType(@PathVariable JobType jobType){
        return  ResponseEntity.ok(jobPostService.findByJobType(jobType));
    }
    @GetMapping("Remote/{remote}")
    public  ResponseEntity<List<JobPostDTO>> getByRemote(@PathVariable String remote){
        return  ResponseEntity.ok(jobPostService.getByRemote(remote));
    }

}