package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.ApplicationDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Application;
import com.JobFindingPlatform.JobFindingPlatform.Enum.ApplicationStatus;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import com.JobFindingPlatform.JobFindingPlatform.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public String applyJob(ApplicationDTO dto){
        if(applicationRepository.findByJobSeekerEmailAndJobId(dto.getJobSeekerEmail(), dto.getJobId()).isPresent()){
            throw new RuntimeException("You already have applied this job");
        }

        Application application = new Application();
        application.setJobId(dto.getJobId());
        application.setJobSeekerName(dto.getJobseekerName());
        application.setJobSeekerEmail(dto.getJobSeekerEmail());
        application.setJobTitle(dto.getJobTitle());
        application.setJobType(dto.getJobType());
        application.setRecruiterEmail(dto.getRecruiterEmail());
        application.setStatus(dto.getStatus());
        application.setAppliedAt(dto.getAppliedAt());
        applicationRepository.save(application);
       return "Applied SuccessFully!!!";
    }

    public List<ApplicationDTO> getByJobSeekerEmail(String jobSeekerEmail){
        return applicationRepository.findByjobSeekerEmail(jobSeekerEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public List<ApplicationDTO> getByRecruiterEmail(String recruiterEmail){
        return  applicationRepository.findByRecruiterEmail(recruiterEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public List<ApplicationDTO> getByJobType(JobType jobType){
        return applicationRepository.findByjobType(jobType).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public  List<ApplicationDTO> getByJobTitle(String jobTitle){
        return applicationRepository.findByJobTitle(jobTitle).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public  List<ApplicationDTO> getByJobId(Long jobId){
        return applicationRepository.findByJobId(jobId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public void updateStatus(Long id, ApplicationStatus status){
        Application app = applicationRepository.findById(id).orElseThrow(()-> new RuntimeException("Application not found"));
        app.setStatus(status);
        applicationRepository.save(app);
    }

    private ApplicationDTO mapToDTO(Application app){
        ApplicationDTO dto = new ApplicationDTO();
        dto.setJobId(app.getJobId());
        dto.setJobSeekerEmail(app.getJobSeekerEmail());
        dto.setJobseekerName(app.getJobSeekerName());
        dto.setRecruiterEmail(app.getRecruiterEmail());
        dto.setJobType(app.getJobType());
        dto.setJobTitle(app.getJobTitle());
        dto.setAppliedAt(app.getAppliedAt());
        dto.setStatus(app.getStatus());
        return dto;
    }
}
