package com.deptrai.osahanfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deptrai.osahanfood.payload.ResponseData;
import com.deptrai.osahanfood.service.FileService;
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	FileService fileService;
@PostMapping("/upfile")
public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file){
	ResponseData responseData = new ResponseData();
	boolean isSuccess = fileService.saveFile(file);
	responseData.setSuccess(isSuccess);
	return new ResponseEntity<>(responseData,HttpStatus.OK);
}
@GetMapping("/files/{filename:.+}")

public ResponseEntity<?> loadFile(@PathVariable String filename){
	
	Resource resource= fileService.loadFile(filename);
	
			 return ResponseEntity.ok()
				        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
}
}
