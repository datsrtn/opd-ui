package com.myopd.opd.stock.dto;

public class StockFilterRequest {
	private Long locationId;
    private String medicineName;
    private Long companyId;
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
}
