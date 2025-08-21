package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.AdminDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.Admin;
import com.JobFindingPlatform.JobFindingPlatform.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("Api/Admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("Getmessage")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Welcome to Admin");
    }

    @PostMapping("PerformAction")
    public ResponseEntity<Admin> performAction(@RequestBody AdminDTO dto){
        return ResponseEntity.ok( adminService.performAction(dto));
    }
    @GetMapping("AdminId/{adminId}")
    public  ResponseEntity<List<Admin>> getActionByAdmin(@PathVariable Long adminId){
        return ResponseEntity.ok(adminService.getActionByAdmin(adminId));
    }
    @GetMapping("UserId/{userId}")
    public  ResponseEntity<List<Admin>> getActionByUser(@PathVariable Long userId){
        return ResponseEntity.ok(adminService.getActionByUser(userId));
    }
}
