package com.myopd.opd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "sales_order_id", nullable = false)
    @JsonBackReference  // Prevents serialization issue
	private SalesOrder salesOrder;

	private String selectedMedicine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

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

	private String selectedMedicineType;
	private String selectedCompany;
	private String selectedLocation;
	private int quantity;
	private double totalPrice;

}
