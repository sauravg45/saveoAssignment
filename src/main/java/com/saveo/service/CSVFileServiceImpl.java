package com.saveo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saveo.entity.Medicine;
import com.saveo.repository.MedicineRepository;
import com.saveo.utility.GeneralUtility;

@Service
public class CSVFileServiceImpl implements CSVFIileService{
	
	@Autowired
	MedicineRepository medicineRepo;
	
	
	@Override
	public Medicine getMedicineDetails(String uniqueCode) {
		return medicineRepo.findByUniqueCode(uniqueCode);
	}
	

	@Override 
	public List<Medicine> searchMedicine(String name){
		return medicineRepo.findByNameContaining(name);
	}


	@Override
	public String save(MultipartFile file) {
		 try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
			        CSVParser csvParser = new CSVParser(fileReader,
			            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			 Iterable<CSVRecord> csvRecords = csvParser.getRecords(); 
			 List<Medicine> medList=new ArrayList<>();
			 
			 for (CSVRecord csvRecord : csvRecords) {
				 Medicine meds=new Medicine(csvRecord.get("c_name"), csvRecord.get("c_batch_no"), GeneralUtility.dateStringToLongConverter(csvRecord.get("d_expiry_date")),Long.parseLong(csvRecord.get("n_balance_qty")), csvRecord.get("c_unique_code"), csvRecord.get("c_schemes"),new BigDecimal(csvRecord .get("n_mrp")), csvRecord.get("c_manufacturer"), Long.parseLong(csvRecord.get("hsn_code")));
				 medList.add(meds);
			 }
			 
			 medicineRepo.save(medList);
			
		 } catch (UnsupportedEncodingException e) {
			
			 return e.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		 
		 return "success uploading";
	}
}
