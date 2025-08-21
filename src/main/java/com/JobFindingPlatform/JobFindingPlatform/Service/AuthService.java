package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.AutheResponseDTO;
import com.JobFindingPlatform.JobFindingPlatform.DTO.LoginRequestDTO;
import com.JobFindingPlatform.JobFindingPlatform.DTO.UserDTO;
import com.JobFindingPlatform.JobFindingPlatform.Entity.UserTable;
import com.JobFindingPlatform.JobFindingPlatform.Repository.UserRepository;
import com.JobFindingPlatform.JobFindingPlatform.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
   @Autowired
   UserRepository userRepository;
   @Autowired
   JWTUtil jwtUtil;
   @Autowired
   PasswordEncoder passwordEncoder;

   public AutheResponseDTO register(UserDTO dto){
       if(userRepository.findByUserEmail(dto.getUserEmail()).isPresent()){
           throw new RuntimeException("User is alredy exits");
       }
       UserTable user=new UserTable();
       user.setUserName(dto.getUserName());
       user.setUserEmail(dto.getUserEmail());
       user.setPassword(passwordEncoder.encode(dto.getPassword()));
       user.setRole(dto.getRole());

       userRepository.save(user);
       String token= jwtUtil.generateToken(user);
       return new AutheResponseDTO(token,"User register successfully!!");
   }

   public String login(LoginRequestDTO requestDTO){
       UserTable user=userRepository.findByUserEmail((requestDTO.getUserEmail())).orElseThrow(()->new RuntimeException("User not found"));

       if(!passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())){
           throw  new RuntimeException("Invalid Credential");
       }
       return jwtUtil.generateToken(user);
   }





}
