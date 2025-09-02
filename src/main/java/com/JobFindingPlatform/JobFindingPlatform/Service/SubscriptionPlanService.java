package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.SubscriptionPlanDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.SubscriptionPlan;
import com.JobFindingPlatform.JobFindingPlatform.Repository.SubscriptionPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlanDTO createSubscription(SubscriptionPlanDTO subscriptionPlanDTO ){

        SubscriptionPlan plan = new SubscriptionPlan();
        plan.setPlanName(subscriptionPlanDTO.getPlanName());
        plan.setPrice(subscriptionPlanDTO.getPrice());
        plan.setCurrency(subscriptionPlanDTO.getCurrency());
        plan.setDuration(subscriptionPlanDTO.getDuration());
        plan.setFeatures(subscriptionPlanDTO.getFeatures());
         SubscriptionPlan createPlan = subscriptionPlanRepository.save(plan);

        return new SubscriptionPlanDTO(
                createPlan.getPlanName(),
                createPlan.getPrice(),
                createPlan.getCurrency(),
                createPlan.getDuration(),
                createPlan.getFeatures()
        );
    }

    public List<SubscriptionPlanDTO>getAll(){
        return subscriptionPlanRepository.findAll().stream()
                .map(plan-> new SubscriptionPlanDTO(
                        plan.getPlanName(),
                        plan.getPrice(),
                        plan.getCurrency(),
                        plan.getDuration(),
                        plan.getFeatures()
                ))
                .collect(Collectors.toList());
    }

    public  SubscriptionPlanDTO getByPlanId(Long id){
        SubscriptionPlan extingplan=subscriptionPlanRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));


        return new SubscriptionPlanDTO(
                extingplan.getPlanName(),
                extingplan.getPrice(),
                extingplan.getCurrency(),
                extingplan.getDuration(),
                extingplan.getFeatures()
        );
    }

    public String deletePlan(Long id) {
        SubscriptionPlan extingplan=subscriptionPlanRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        subscriptionPlanRepository.delete(extingplan);
        return "Delete Successfully!!";
    }
}
