package com.JobFindingPlatform.JobFindingPlatform.Entity;

import com.JobFindingPlatform.JobFindingPlatform.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userEmail;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
