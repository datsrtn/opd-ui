
package com.myopd.opd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class ExpiringMedicine {

	
	private Long unit_id;

	public Long getId() {
		return unit_id;
	}

	public void setId(Long id) {
		this.unit_id = id;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	private String medicineType;

	// Getters and Setters

}
