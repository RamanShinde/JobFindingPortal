package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.JobPostDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.JobPost;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import com.JobFindingPlatform.JobFindingPlatform.Repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostService {
    @Autowired
    JobPostRepository jobPostRepository;

    public String createJobPost(JobPostDTO dto){

        JobPost jobPost =new JobPost();
        jobPost.setJobTitle(dto.getJobTitle());
        jobPost.setJobType(dto.getJobType());
        jobPost.setJobCatogory(dto.getJobCatogory());
        jobPost.setJobLocation(dto.getJobLocation());
        jobPost.setRemote(dto.getRemote());
        jobPost.setCompanyName(dto.getCompanyName());
        jobPost.setJobDescription(dto.getJobDescription());
        jobPost.setPostedBy(dto.getPostedBy());
        jobPost.setPostedAt(dto.getPostedAt());
        jobPostRepository.save(jobPost);
        return "Job got posted";
    }
    public List<JobPostDTO> getByCompanyName(String companyName){
      return jobPostRepository.findByCompanyName(companyName).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public  List<JobPostDTO> getByPostedBy(String postedBy){
        return jobPostRepository.findByPostedBy(postedBy).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public  List<JobPostDTO> getByJobTitle(String jobTitle){
        return jobPostRepository.findByJobTitle(jobTitle).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public  List<JobPostDTO>findByJobType(JobType jobType){
        return jobPostRepository.findByJobType(jobType).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public  List<JobPostDTO>getByRemote(String remote){
        return  jobPostRepository.findByRemote(remote).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private JobPostDTO mapToDTO(JobPost jobPost){
        JobPostDTO dto= new JobPostDTO();
        dto.setJobTitle(jobPost.getJobTitle());
        dto.setJobType(jobPost.getJobType());
        dto.setJobCatogory(jobPost.getJobCatogory());
        dto.setJobLocation(jobPost.getJobLocation());
        dto.setRemote(jobPost.getRemote());
        dto.setCompanyName(jobPost.getCompanyName());
        dto.setJobDescription(jobPost.getJobDescription());
        dto.setPostedAt(jobPost.getPostedAt());
        dto.setPostedAt(dto.getPostedAt());
        return dto;
    }

}