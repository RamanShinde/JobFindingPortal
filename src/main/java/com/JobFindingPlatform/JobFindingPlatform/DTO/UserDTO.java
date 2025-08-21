package com.JobFindingPlatform.JobFindingPlatform.DTO;

import com.JobFindingPlatform.JobFindingPlatform.Enum.Role;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String userName;
    private String userEmail;
    private String password;
    private Role role;
}
