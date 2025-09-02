package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.PaymentRequestDTO;
import com.JobFindingPlatform.JobFindingPlatform.DTO.PaymentResponseDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Payment;
import com.JobFindingPlatform.JobFindingPlatform.Enum.PaymentStatus;
import com.JobFindingPlatform.JobFindingPlatform.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponseDTO processPayment(PaymentRequestDTO dto){
        Payment pay= new Payment();
        pay.setUserId(dto.getUserId());
        pay.setPlanId(dto.getPlanId());
        pay.setAmount(dto.getAmount());
        pay.setPaymentStatus(PaymentStatus.SUCCESS);
        pay.setTransactionId(UUID.randomUUID().toString());
        paymentRepository.save(pay);

        PaymentResponseDTO responseDTO= new PaymentResponseDTO();
        responseDTO.setTransactionId(pay.getTransactionId());
        responseDTO.setPaymentStatus(pay.getPaymentStatus());
        responseDTO.setAmount(pay.getAmount());
        return responseDTO;
    }
}
