package com.myopd.opd.dto.medicine;

import java.util.Date;

public class PurchaseOrderMedicineDTO {
	private Long  medicineId;
	private String medicineName;
	//private String medicineType;
	private String companyName;
	private Date expiryDate;
	private float pricePerUnit;
	private String locationName;
	private String batch;
	private long quantity;

	public PurchaseOrderMedicineDTO(Long medicineId, String medicineName,  String companyName, Date expiryDate, float pricePerUnit, String locationName, String batch, long quantity) {
		this.medicineName = medicineName;
		this.medicineId = medicineId; // Set to null or assign a value if available
		this.companyName = companyName;
		this.expiryDate = expiryDate;
		this.pricePerUnit = pricePerUnit;
		this.locationName = locationName;
		this.batch = batch;
		this.setQuantity(quantity);
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

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

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



	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}



	public Long getMedicineId() {
		return medicineId;
	}



	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}



}