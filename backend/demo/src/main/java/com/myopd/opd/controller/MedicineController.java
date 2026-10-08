package com.myopd.opd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myopd.opd.dto.medicine.ExpiringMedicinesDTO;
import com.myopd.opd.dto.medicine.MedicineDTO;
import com.myopd.opd.dto.medicine.MedicineDetailsDTO;
import com.myopd.opd.dto.medicine.NearingOutOfStockDTO;
import com.myopd.opd.dto.medicine.PurchaseOrderWrapper;
import com.myopd.opd.service.MedicineService;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
	
	
	private final MedicineService medicineService;
	
	public MedicineController(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
	
	
	@GetMapping("/expired")
	public List<ExpiringMedicinesDTO> getExpiredMedicines() {
		List<ExpiringMedicinesDTO> x=  medicineService.getAllExpiringMedicines();
		return x;
	}
	
	@GetMapping("/nearingOutOfstock")
	public List<NearingOutOfStockDTO> getNearingOutOfStockMedicines() {
		List<NearingOutOfStockDTO> x=  medicineService.getNearingOutOfStockMedicines();
		return x;
	}
	
	@GetMapping("/all") 
	public  List<PurchaseOrderWrapper> getAlltMedicines() {
		List<PurchaseOrderWrapper> m= medicineService.getAllMedicines();
		return m;
	}
	
	
	@GetMapping("/alldistinct") 
	public  List<MedicineDTO> getAllDistinctMedicines() {
		List<MedicineDTO> m= medicineService.findAllDistinctMedicines();
		return m;
	}
	
//	@GetMapping("/all/location/{id}")
//	public List<MedicineDTO> getMedicinesByLocation(@PathVariable Long id) {
//		List<MedicineDTO> m = medicineService.getMedicinesByLocation(id);
//		return m;
//	}

	@GetMapping("/getLocationWiseStock/{name}")
	public List<NearingOutOfStockDTO> getLocationWiseStock(@PathVariable Long id) {
	//	List<NearingOutOfStockDTO> x=  medicineService.getLocationWiseStocks(id);
		return null;
	}
	

}
