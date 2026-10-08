package com.myopd.opd.dto;

import java.time.LocalDate;

public class LocationMedicineDTO {

	    private String medicineName;
	    private String companyName;
	    private Integer quantity;
	    private LocalDate expiryDate;
		public String getMedicineName() {
			return medicineName;
		}
		public void setMedicineName(String medicineName) {
			this.medicineName = medicineName;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public LocalDate getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(LocalDate expiryDate) {
			this.expiryDate = expiryDate;
		}
	}
