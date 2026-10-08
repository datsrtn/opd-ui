/**
 * 
 */
package com.myopd.opd.dto.sale;

/**
 * This is DTO getting used to transfer data of Single order from the sales
 * table
 */
public class OrderItemDTO {
	private Long medicineId;
	private String selectedMedicine;
	private String selectedMedicineType;
	private String selectedCompany;
	private String selectedLocation;
	private int quantity;
	private double totalPrice;

	public String getSelectedMedicine() {
		return selectedMedicine;
	}

	public void setSelectedMedicine(String selectedMedicine) {
		this.selectedMedicine = selectedMedicine;
	}

	public String getSelectedMedicineType() {
		return selectedMedicineType;
	}

	public void setSelectedMedicineType(String selectedMedicineType) {
		this.selectedMedicineType = selectedMedicineType;
	}

	public String getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(String selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	public String getSelectedLocation() {
		return selectedLocation;
	}

	public void setSelectedLocation(String selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [selectedMedicine=" + selectedMedicine + ", selectedMedicineType=" + selectedMedicineType
				+ ", selectedCompany=" + selectedCompany + ", selectedLocation=" + selectedLocation + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice +"medicine Id="+ medicineId + "]";
	}

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

}
