package com.JobFindingPlatform.JobFindingPlatform.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="job_seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jobseeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String phone;
    private String colleageName;
    private String universityName;
    private String degree;
    private LocalDate passingYear;
    private String resumeURL;
    private boolean active;



}
