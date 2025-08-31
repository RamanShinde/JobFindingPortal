package com.JobFindingPlatform.JobFindingPlatform.Entity;

import com.JobFindingPlatform.JobFindingPlatform.Enum.Duration;
import com.JobFindingPlatform.JobFindingPlatform.Enum.PlanName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PlanDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private PlanName planName;
    private Double price;
    private String currency;
    private Duration duration;
    private String features;
}
