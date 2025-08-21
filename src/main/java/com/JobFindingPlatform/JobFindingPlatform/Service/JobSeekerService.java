package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.JobseekerDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Jobseeker;
import com.JobFindingPlatform.JobFindingPlatform.Repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class JobSeekerService {
    @Autowired
   JobSeekerRepository jobSeekerRepository;

    public JobseekerDTO createJobSeekerProfile(JobseekerDTO dto){
        Jobseeker jobseeker=new Jobseeker();
        jobseeker.setFullName(dto.getFullName());
        jobseeker.setEmail(dto.getEmail());
        jobseeker.setColleageName(dto.getColleageName());
        jobseeker.setUniversityName(dto.getUniversityName());
        jobseeker.setDegree(dto.getDegree());
        jobseeker.setPassingYear(dto.getPassingYear());
        jobseeker.setResumeURL(dto.getResumeURL());
        jobseeker.setActive(dto.isActive());

         jobSeekerRepository.save(jobseeker);
        return dto;
    }

    public Optional<JobseekerDTO> getByEmail(String email){
        return jobSeekerRepository.findByEmail(email).map(jobseeker -> {
            JobseekerDTO dto=new JobseekerDTO();
            dto.setFullName(jobseeker.getFullName());
            dto.setEmail(jobseeker.getEmail());
            dto.setColleageName(jobseeker.getColleageName());
            dto.setUniversityName(jobseeker.getUniversityName());
            dto.setDegree(jobseeker.getDegree());
            jobseeker.setResumeURL(jobseeker.getResumeURL());
            return dto;
        });

    }

    public  Optional<JobseekerDTO>getById(Long id){
        return  jobSeekerRepository.findById(id).map(jobseeker -> {
            JobseekerDTO dto=new JobseekerDTO();
            dto.setFullName(jobseeker.getFullName());
            dto.setEmail(jobseeker.getEmail());
            dto.setColleageName(jobseeker.getColleageName());
            dto.setUniversityName(jobseeker.getUniversityName());
            dto.setDegree(jobseeker.getDegree());
            jobseeker.setResumeURL(jobseeker.getResumeURL());
            return dto;
        });
    }
}
