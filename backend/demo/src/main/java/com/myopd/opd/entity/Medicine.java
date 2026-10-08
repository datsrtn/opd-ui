package com.myopd.opd.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "medicine_master")

public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_id")
	private Long medicineId;

	@Column(name = "medicine_name")
	private String medicineName;
	private String description;
	@Column(name = "price_per_unit")
	private float pricePerUnit;
	@Column(name = "expiry_date")
	private Date expiryDate;
	@Column(name = "quantity_in_stock")
	private long quantityInStock;
//

	@Column(name = "location_id")
	private int locationId;


	@Column(name = "company_id")
	private int companyId;
	
	@Column(name = "batch")
	private String batch;

//	@ManyToOne
//	@JoinColumn(name = "company_id", referencedColumnName = "companyId")
//	private Company company;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "location_id", referencedColumnName = "locationId")
//	private Location location;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "unit_id", referencedColumnName = "unitId")
//	private Unit unit;

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/*
	 * public String getLocation() { return location; }
	 * 
	 * public void setLocation(String location) { this.location = location; }
	 */
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		locationId = locationId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", description=" + description
				+ ", pricePerUnit=" + pricePerUnit + ", expiryDate=" + expiryDate + ", quantityInStock="
				+ quantityInStock + ",  locationId=" + locationId + ", companyId=" + companyId
				+ ", batch=" + batch + "]";
	}

//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}
//
//	public Location getLocation() {
//		return location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//
//	public Unit getUnit() {
//		return unit;
//	}
//
//	public void setUnit(Unit unit) {
//		this.unit = unit;
//	}

}
