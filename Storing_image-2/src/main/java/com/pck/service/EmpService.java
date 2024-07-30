package com.pck.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.pck.entity.UserEntity;

public interface EmpService 
{
	
	public UserEntity saveemp(String name,MultipartFile image) throws IOException;
	
	  public Optional<UserEntity> getImage(Integer id);
	  
	  Resource getImageByUserId(Integer id) throws IOException;

}
