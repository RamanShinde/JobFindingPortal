package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.RecruiterDTO;
import com.JobFindingPlatform.JobFindingPlatform.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("Api/Recruiter")
public class RecruiterController {
    @Autowired
    RecruiterService recruiterService;

    @PostMapping("Create")
    public ResponseEntity<RecruiterDTO> createRecruiterProfile(@RequestBody RecruiterDTO dto){
        return ResponseEntity.ok(recruiterService.createRecruiterProfile(dto));
    }

    @GetMapping("email/{recruiterEmail}")
    public ResponseEntity<Optional<RecruiterDTO>> getByEmail(@PathVariable String recruiterEmail){
        return ResponseEntity.ok(recruiterService.findByEmail(recruiterEmail));
    }

    @GetMapping("Id/{Id}")
    public  ResponseEntity<Optional<RecruiterDTO>> getById(@PathVariable Long Id){
        return ResponseEntity.ok(recruiterService.findById(Id));
    }

}
