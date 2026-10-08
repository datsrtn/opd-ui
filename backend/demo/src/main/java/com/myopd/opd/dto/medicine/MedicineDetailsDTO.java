package com.myopd.opd.dto.medicine;

import java.util.Date;

public class MedicineDetailsDTO {
	private String medicineName;
	private String description;
	private float pricePerUnit;
	private int manufacturer;
	private Date expiryDate;
	private long quantityInStock;
	private String location;

	private int LocationId;
	private int companyId;

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

	public int getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(int manufacturer) {
		this.manufacturer = manufacturer;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public int getLocationId() {
		return LocationId;
	}

	public void setLocationId(int locationId) {
		LocationId = locationId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
