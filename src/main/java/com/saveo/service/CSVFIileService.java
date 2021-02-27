package com.saveo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saveo.entity.Medicine;

@Service
public interface CSVFIileService {

	public Medicine getMedicineDetails(String uniqueCode);

	public List<Medicine> searchMedicine(String name);
	
	public String save(MultipartFile file);

}
