package com.JobFindingPlatform.JobFindingPlatform.Controller;


import com.JobFindingPlatform.JobFindingPlatform.DTO.SubscriptionPlanDTO;
import com.JobFindingPlatform.JobFindingPlatform.Service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/SubscriptionPlan")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping("CreatePlan")
    public ResponseEntity<SubscriptionPlanDTO> createPlane(@RequestBody SubscriptionPlanDTO subscriptionPlanDTO){
        return ResponseEntity.ok(subscriptionPlanService.createSubscription(subscriptionPlanDTO));
    }
    @GetMapping("GetAllPlan")
    public ResponseEntity<List<SubscriptionPlanDTO>>getAllPlan(){
        return ResponseEntity.ok(subscriptionPlanService.getAll());
    }
    @GetMapping("GetPlanById/{id}")
    public  ResponseEntity<SubscriptionPlanDTO>getPlanyById(@PathVariable Long id){
        return  ResponseEntity.ok(subscriptionPlanService.getByPlanId(id));
    }
    @DeleteMapping("DeletenyId/{id}")
    public  ResponseEntity<String> deletePlan(@PathVariable Long id){
        return ResponseEntity.ok(subscriptionPlanService.deletePlan(id));
    }

}
