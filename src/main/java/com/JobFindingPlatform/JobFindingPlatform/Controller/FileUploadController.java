package com.JobFindingPlatform.JobFindingPlatform.Controller;

import com.JobFindingPlatform.JobFindingPlatform.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("Api/Upload")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/Resume")
    public ResponseEntity<String>uploadResume(@RequestParam MultipartFile file) throws IOException {
        String url= fileUploadService.uploadFile(file,"resume");
        return ResponseEntity.ok(url);
    }

    @PostMapping("/Certificate")
    public ResponseEntity<String> uploadCertificate(@RequestParam MultipartFile file) throws IOException {
        String url= fileUploadService.uploadFile(file,"resume");
        return ResponseEntity.ok(url);
    }

}