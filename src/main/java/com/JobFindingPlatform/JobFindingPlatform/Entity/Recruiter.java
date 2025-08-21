package com.JobFindingPlatform.JobFindingPlatform.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="recruiters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String recruiterName;
    @Column(unique = true)
    private String recruiterEmail;
    private String phone;
    private String companyName;
    private String designation;
}
