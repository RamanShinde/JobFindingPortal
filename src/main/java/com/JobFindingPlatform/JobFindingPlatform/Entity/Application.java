package com.JobFindingPlatform.JobFindingPlatform.Entity;

import com.JobFindingPlatform.JobFindingPlatform.Enum.ApplicationStatus;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="ApplicationTable")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobSeekerName;
    @Column(unique = true)
    private String jobSeekerEmail;
    private Long jobId;
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    @Column(unique = true)
    private String recruiterEmail;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
}
