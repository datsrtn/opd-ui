package com.myopd.opd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.myopd.opd.dto.medicine.ExpiringMedicinesDTO;
import com.myopd.opd.dto.medicine.MedicineDetailsDTO;
import com.myopd.opd.entity.Medicine;

@Mapper(componentModel = "spring")

public interface MedicineMapper {

	MedicineMapper INSTNACE =  Mappers.getMapper(MedicineMapper.class);
	
	MedicineDetailsDTO toDTO(Medicine medicine);
	
	Medicine toMedicine(MedicineDetailsDTO medicineDto);
	

			
}
