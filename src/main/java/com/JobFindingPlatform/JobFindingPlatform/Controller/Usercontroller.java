package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.DTO.AutheResponseDTO;
import com.JobFindingPlatform.JobFindingPlatform.DTO.LoginRequestDTO;
import com.JobFindingPlatform.JobFindingPlatform.DTO.UserDTO;
import com.JobFindingPlatform.JobFindingPlatform.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class Usercontroller {

    @Autowired
    AuthService authService;

    @GetMapping("getMessage")   // it used to fecth the details from the DB
    public String getMessage(){
        return "Welcome the JobPortal";
    }

    @PostMapping("register")
    public AutheResponseDTO register(@RequestBody UserDTO dto){
        return authService.register(dto);
    }
    @PostMapping("login")
    public  String login(@RequestBody LoginRequestDTO requestDTO){
        return  authService.login(requestDTO);
    }
}