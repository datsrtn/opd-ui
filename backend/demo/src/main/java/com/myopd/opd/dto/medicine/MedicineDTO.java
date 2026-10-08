package com.myopd.opd.dto.medicine;

public class MedicineDTO {
	
	private Long medicineId;
	private String medicineName;
	
	
	public MedicineDTO(Long medicineId, String medicineName) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
	}
	
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long  medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

}
