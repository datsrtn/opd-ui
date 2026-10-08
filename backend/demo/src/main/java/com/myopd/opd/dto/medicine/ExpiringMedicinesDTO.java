package com.myopd.opd.dto.medicine;

import java.util.Date;

import com.myopd.opd.entity.Medicine;

public class ExpiringMedicinesDTO {

	private String medicineName;
	private String medicineType;
	private String companyName;
	private Date expiryDate;

	
	public ExpiringMedicinesDTO (String medicineName,  String medicineType, String companyName, Date expiryDate){
		this.medicineName = medicineName;
		this.medicineType = medicineType;	
		this.companyName =  companyName;
		this.expiryDate = expiryDate;
		
	}
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
