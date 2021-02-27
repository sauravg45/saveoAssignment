package com.saveo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.saveo.entity.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	public Medicine findByUniqueCode(String uniqueCode);
	
	public List<Medicine> findByNameContaining(String name);
}
