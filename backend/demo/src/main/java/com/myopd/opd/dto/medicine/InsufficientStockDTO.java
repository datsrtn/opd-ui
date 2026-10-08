package com.myopd.opd.dto.medicine;

public class InsufficientStockDTO {
	  private Long medicineId;
	    private String medicineName;
	    private String location;
	    private Integer requiredQuantity;

	    public InsufficientStockDTO(
	            Long medicineId,
	            String medicineName,
	            String location,
	            Integer requiredQuantity) {
	        this.medicineId = medicineId;
	        this.medicineName = medicineName;
	        this.location = location;
	        this.requiredQuantity = requiredQuantity;
	    }

		public Long getMedicineId() {
			return medicineId;
		}

		public void setMedicineId(Long medicineId) {
			this.medicineId = medicineId;
		}

		public String getMedicineName() {
			return medicineName;
		}

		public void setMedicineName(String medicineName) {
			this.medicineName = medicineName;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public Integer getRequiredQuantity() {
			return requiredQuantity;
		}

		public void setRequiredQuantity(Integer requiredQuantity) {
			this.requiredQuantity = requiredQuantity;
		}

		@Override
		public String toString() {
			return "InsufficientStockDTO [medicineId=" + medicineId + ", medicineName=" + medicineName + ", location="
					+ location + ", requiredQuantity=" + requiredQuantity + "]";
		}
}
