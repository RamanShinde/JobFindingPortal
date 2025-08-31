package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class FileUploadService {
    @Autowired
    private Cloudinary cloudinary;

    public FileUploadService(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret
    ){
       this.cloudinary=new Cloudinary(ObjectUtils.asMap(  "cloud_name", cloudName,
               "api_key", apiKey,
               "api_secret", apiSecret,
               "secure", true));
    }

    public  String uploadFile(MultipartFile file,String folder) throws IOException {
        Map uploadResult=cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap("folder",folder,"resource_type","auto")
        );
        return uploadResult.get("secure_url").toString();
    }
}
