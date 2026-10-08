package com.myopd.opd.dto.medicine;

public class NearingOutOfStockDTO {

	private String medicineName;
	private String companyName;
	private long stockRemaining;
	private String medicineType;
	private String batch;
	private String location;

	public NearingOutOfStockDTO(String medicineName, String companyName, long quantityInStock, String medicineType,
			String batch, String location) {
		this.medicineName = medicineName;
		this.companyName = companyName;
		this.stockRemaining = quantityInStock;
		this.medicineType = medicineType;
		this.batch = batch;
		this.location = location;
		

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

	public long getStockRemaining() {
		return stockRemaining;
	}

	public void setStockRemaining(long stockRemaining) {
		this.stockRemaining = stockRemaining;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
