package com.JobFindingPlatform.JobFindingPlatform.DTO;

import com.JobFindingPlatform.JobFindingPlatform.Enum.ApplicationStatus;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO {
    private String jobseekerName;
    private String jobSeekerEmail;
    private String recruiterEmail;
    private Long jobId;
    private String jobTitle;
    private JobType jobType;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
}
