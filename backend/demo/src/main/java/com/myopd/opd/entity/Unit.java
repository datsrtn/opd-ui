package com.myopd.opd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "unit_master") // Ensure this matches your table name

public class Unit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name  = "unit_id")
	private int unitId;
	@Column(name  = "unit_name")
	private String unit;

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
