package com.pck.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.pck.entity.UserEntity;
import com.pck.service.EmpService;

//import jakarta.annotation.Resource;

@RestController
public class Controller 
{
	
	@Autowired
	private EmpService serv; 	
	
	 @PostMapping("/add")
	    public UserEntity uploadImage(@RequestParam String name, @RequestParam("file") MultipartFile file) throws IOException {
	        // Convert MultipartFile to File
//	        File imageFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
//	        file.transferTo(imageFile);
	        
	        return serv.saveemp(name, file);
	    }
	 
	 @GetMapping("/user/{id}")
	    public ResponseEntity<Resource> getUserImageById(@PathVariable Integer id) {
	        try {
	            Resource resource = serv.getImageByUserId(id);
	            if (resource.exists() || resource.isReadable()) {
	                return ResponseEntity.ok()
	                        .contentType(MediaType.IMAGE_JPEG) // Set appropriate media type if different
	                        .body(resource);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body(null);
	        }
	    }
}
