package com.JobFindingPlatform.JobFindingPlatform.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruiterDTO {
    private String recruiterName;
    @Column(unique = true)
    private String recruiterEmail;
    private String phone;
    private String companyName;
    private String designation;
}
