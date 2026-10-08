package com.myopd.opd.service;

import java.util.List;

import com.myopd.opd.dto.LocationsDetailsDTO;
import com.myopd.opd.dto.medicine.ExpiringMedicinesDTO;
import com.myopd.opd.dto.medicine.MedicineDTO;

import com.myopd.opd.dto.medicine.NearingOutOfStockDTO;

public interface MedicineService {
	
	public List getAllMedicines();
	
	public List<ExpiringMedicinesDTO> getAllExpiringMedicines();

	public List<NearingOutOfStockDTO> getNearingOutOfStockMedicines();
	
	public List<LocationsDetailsDTO> getLocationWiseStock();

	List<MedicineDTO> findAllDistinctMedicines();
	

	
	List<MedicineDTO> findByLocationId(Long id);

}
