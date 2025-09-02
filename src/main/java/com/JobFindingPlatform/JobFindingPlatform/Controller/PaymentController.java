package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.PaymentRequestDTO;
import com.JobFindingPlatform.JobFindingPlatform.DTO.PaymentResponseDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Payment;
import com.JobFindingPlatform.JobFindingPlatform.Entity.SubscriptionPlan;
import com.JobFindingPlatform.JobFindingPlatform.Repository.PaymentRepository;
import com.JobFindingPlatform.JobFindingPlatform.Repository.SubscriptionPlanRepository;
import com.JobFindingPlatform.JobFindingPlatform.Service.InVoiceService;
import com.JobFindingPlatform.JobFindingPlatform.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/Payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SubscriptionPlanRepository subPlanRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private InVoiceService inVoiceService;


    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO>process(@RequestBody PaymentRequestDTO dto ){
        return ResponseEntity.ok(paymentService.processPayment(dto));
    }

    @GetMapping("/plans")
    public ResponseEntity<List<SubscriptionPlan>>getPlans(){
        return ResponseEntity.ok(subPlanRepo.findAll());
    }
    @PostMapping ResponseEntity<SubscriptionPlan>createPlans(@RequestBody SubscriptionPlan plan){
        return ResponseEntity.ok(subPlanRepo.save(plan));
    }
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Payment>>history(@PathVariable Long userId){
        return ResponseEntity.ok(paymentRepo.findByUserId(userId));
    }


    @GetMapping("/invoice/{paymentId}")
    public ResponseEntity<byte[]>downloadInvoice(@PathVariable Long paymentId){

        Payment pay = paymentRepo.findById(paymentId).orElseThrow(()-> new RuntimeException("Payment not found"));
        byte[] pdfBytes = inVoiceService.generateInvoice(pay);

        return ResponseEntity.ok()
                .header("Content-Diposition", "Attachment; fileNameInvoice-" +pay.getTransactionId() + ".pdf")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(pdfBytes);
    }


}
