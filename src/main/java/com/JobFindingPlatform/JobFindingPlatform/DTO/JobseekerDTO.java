package com.JobFindingPlatform.JobFindingPlatform.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobseekerDTO {
    private String fullName;
    private String email;
    private String phone;
    private String colleageName;
    private String universityName;
    private String degree;
    private LocalDate passingYear;
    private String resumeURL;
    private boolean active;
}
