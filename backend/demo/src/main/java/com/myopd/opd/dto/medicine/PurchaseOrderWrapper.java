package com.myopd.opd.dto.medicine;

import java.util.List;

public class PurchaseOrderWrapper {

	private String medicineName;
	private List<PurchaseOrderMedicineDTO> details;

	public PurchaseOrderWrapper(String medicineName, List<PurchaseOrderMedicineDTO> details) {
		this.medicineName = medicineName;
		this.details = details;
	}

	public String getMedicineName() {
		return medicineName;
	} 

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public List<PurchaseOrderMedicineDTO> getDetails() {
		return details;
	}

	public void setDetails(List<PurchaseOrderMedicineDTO> details) {
		this.details = details;
	}
}