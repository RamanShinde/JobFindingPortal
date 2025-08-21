package com.JobFindingPlatform.JobFindingPlatform.Entity;


import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="jobPosts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    private String jobLocation;
    private String remote;
    private String companyName;
    private String jobCatogory;
    private String jobDescription;
    private String postedBy;
    private LocalDateTime postedAt;
}