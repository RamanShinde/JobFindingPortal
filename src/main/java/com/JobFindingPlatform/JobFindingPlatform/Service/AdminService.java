package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.AdminDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Admin;
import com.JobFindingPlatform.JobFindingPlatform.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
 @Autowired
 AdminRepository adminRepository;

 public Admin performAction(AdminDTO dto){
     Admin admin =new Admin();

     admin.setAdminId(dto.getAdminID());
     admin.setUserId(dto.getUserId());
     admin.setAction(dto.getAction());
     admin.setTimeStamp(dto.getTimeStamp());

     return adminRepository.save(admin);
 }
 public List<Admin> getActionByAdmin(Long adminId){
     return adminRepository.findByAdminId(adminId);
 }
 public  List<Admin> getActionByUser(Long userId){
     return adminRepository.findByUserId(userId);
 }

}