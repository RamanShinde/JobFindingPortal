package com.JobFindingPlatform.JobFindingPlatform.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutheResponseDTO {
    public String token;
    public String message;

    public AutheResponseDTO(String token,String message){
        this.token=token;
        this.message=message;
    }
}
