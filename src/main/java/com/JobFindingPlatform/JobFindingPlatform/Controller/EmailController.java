package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.EmailRequestDTO;
import com.JobFindingPlatform.JobFindingPlatform.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api/Email")
public class EmailController {

    @Autowired
   private EmailService emailService ;  // ✅ no need for full package path

    @PostMapping("/SendMail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO dto) {
        return ResponseEntity.ok(emailService.sendEmail(dto));
    }
}
