package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.JobseekerDTO;
import com.JobFindingPlatform.JobFindingPlatform.Service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("Api/JobSeeker")
public class JobSeekerController {

    @Autowired
    JobSeekerService seekerService;

    @PostMapping("Create")
    public ResponseEntity<JobseekerDTO> createJobseekerProfile(@RequestBody JobseekerDTO dto){
        return ResponseEntity.ok(seekerService.createJobSeekerProfile(dto));
    }
    @GetMapping("Email/{email}")
    public ResponseEntity<Optional<JobseekerDTO>> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(seekerService.getByEmail(email));
    }
    @GetMapping("Id/{id}")
    public ResponseEntity<Optional<JobseekerDTO>> getById(@PathVariable Long id){
        return ResponseEntity.ok(seekerService.getById(id));
    }

}