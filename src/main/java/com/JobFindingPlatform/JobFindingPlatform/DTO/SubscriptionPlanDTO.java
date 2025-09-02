package com.JobFindingPlatform.JobFindingPlatform.DTO;

import com.JobFindingPlatform.JobFindingPlatform.Enum.Duration;
import com.JobFindingPlatform.JobFindingPlatform.Enum.PlanName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlanDTO {
    @Enumerated(EnumType.STRING)
    private PlanName planName;
    private Double price;
    private String currency;
    @Enumerated(EnumType.STRING)
    private Duration duration;
    private String features;

}
