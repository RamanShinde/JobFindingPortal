package com.JobFindingPlatform.JobFindingPlatform.Service;


import com.JobFindingPlatform.JobFindingPlatform.DTO.RecruiterDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Recruiter;
import com.JobFindingPlatform.JobFindingPlatform.Repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
   RecruiterRepository recruiterRepository;

    public RecruiterDTO createRecruiterProfile(RecruiterDTO dto) {
        Recruiter recruiter=new Recruiter();
        recruiter.setRecruiterName(dto.getRecruiterName());
        recruiter.setRecruiterEmail(dto.getRecruiterEmail());
        recruiter.setPhone(dto.getPhone());
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setDesignation(dto.getDesignation());
        Recruiter addRecruiter=recruiterRepository.save(recruiter);
        return mapToDTO(addRecruiter);
    }


   public Optional<RecruiterDTO> findByEmail(String email){
        return recruiterRepository.findByRecruiterEmail(email).map(this::mapToDTO);
   }

   public Optional<RecruiterDTO> findById(Long id){
        return recruiterRepository.findById(id).map(this::mapToDTO);
   }




    private RecruiterDTO mapToDTO(Recruiter req) {
        RecruiterDTO dto=new RecruiterDTO();
        dto.setRecruiterName(req.getRecruiterName());
        dto.setRecruiterEmail(req.getRecruiterEmail());
        dto.setPhone(req.getPhone());
        dto.setCompanyName(req.getCompanyName());
        dto.setDesignation(req.getDesignation());
     return dto;
    }
}
