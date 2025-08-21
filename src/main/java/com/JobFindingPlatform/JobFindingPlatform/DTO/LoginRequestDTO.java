package com.JobFindingPlatform.JobFindingPlatform.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {
    private String userEmail;
    private String password;
}
