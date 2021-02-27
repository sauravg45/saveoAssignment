/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saveo.controller;

import com.saveo.entity.Medicine;
import com.saveo.service.CSVFIileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class AppController {

@Autowired
CSVFIileService csvFileService;
	
   


   @GetMapping("/getMedicineDetails")
   public @ResponseBody Medicine getMedicineDetails(@RequestParam String uniqueId) {
	   return  csvFileService.getMedicineDetails(uniqueId);
			   
   }
   
   @GetMapping("/searchMedicine")
   public @ResponseBody List<Medicine> searchMedicine(@RequestParam String medicineName){
	   return csvFileService.searchMedicine(medicineName);
   }
  
   
   @PostMapping("/upload")
   public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file){
	String status=csvFileService.save(file);
	if(status.equalsIgnoreCase("success uploading")) {
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
		return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}