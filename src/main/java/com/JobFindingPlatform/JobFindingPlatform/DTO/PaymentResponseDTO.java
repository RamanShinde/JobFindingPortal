package com.JobFindingPlatform.JobFindingPlatform.DTO;

import com.JobFindingPlatform.JobFindingPlatform.Enum.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDTO {
    private String transactionId;
    private PaymentStatus paymentStatus;
    private Double amount;
}
