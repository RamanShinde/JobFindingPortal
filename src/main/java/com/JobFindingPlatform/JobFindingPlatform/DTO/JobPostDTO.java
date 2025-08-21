package com.JobFindingPlatform.JobFindingPlatform.DTO;

import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPostDTO {
    private String jobTitle;
    private JobType jobType;
    private String jobLocation;
    private String remote;
    private String companyName;
    private String jobCatogory;
    private String jobDescription;
    private String postedBy;
    private LocalDateTime postedAt;
}