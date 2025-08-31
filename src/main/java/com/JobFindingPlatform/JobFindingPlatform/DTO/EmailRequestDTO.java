package com.JobFindingPlatform.JobFindingPlatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.Subject;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequestDTO {

    private String to;
    private String subject;
    private String body;

}
