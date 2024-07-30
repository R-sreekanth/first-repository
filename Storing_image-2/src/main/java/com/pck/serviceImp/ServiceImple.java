package com.pck.serviceImp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.pck.entity.UserEntity;
//import com.pck.entity.Entity;
import com.pck.imageutil.ImageUtil;
import com.pck.repo.Repo;
import com.pck.service.EmpService;
import org.springframework.core.io.FileSystemResource;

@Service
public class ServiceImple implements EmpService
{

	@Autowired
	private Repo repo;
	
	 private final String storageDirectory = System.getProperty("user.dir") + "/images/";
	
	@Override
	public UserEntity saveemp(String name, MultipartFile image) throws IOException 
	{
		

		    
		        // Create the storage directory if it doesn't exist
		        File directory = new File(storageDirectory);
		        if (!directory.exists()) {
		            directory.mkdirs();
		        }

		        // Save the file locally
		        Path filePath = Paths.get(storageDirectory, image.getOriginalFilename());
		        Files.write(filePath, image.getBytes());

		        // Create the image URL (this would be the URL to access the image)
		        String imageUrl = "/images/" + image.getOriginalFilename();

		        // Save the image entity
		        UserEntity imagee = new UserEntity();
		        imagee.setUserName(name);
		        imagee.setImage(imageUrl);
		        return repo.save(imagee);
		    
//		String base64Image = ImageUtil.encodeImageToBase64(image);
//        UserEntity e = new UserEntity();
//        e.setUserName(name);
//        e.setImage(base64Image);
//        repo.save(e);
//        return "image saved successfuly";
	}

	  public Optional<UserEntity> getImage(Integer id) {
	        return repo.findById(id);
	    }

	@Override
	public Resource getImageByUserId(Integer id) throws IOException {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntityOptional = repo.findById(id);
        if (userEntityOptional.isPresent()) {
            String imageUrl = userEntityOptional.get().getImage();
            Path filePath = Paths.get(storageDirectory).resolve(imageUrl.replace("/images/", ""));
            return new UrlResource(filePath.toUri());
        } else {
            throw new IOException("User not found or image not available");
        }
    }
	}
	
    
//		Optional<UserEntity> ispresent=repo.findById(id);
//		if(ispresent.isPresent())
//		{
//			String base64Image = ispresent.get().getImage();
//            return ImageUtil.decodeBase64ToImage(base64Image);
//			
//		}
//		  throw new RuntimeException("Image not found");



