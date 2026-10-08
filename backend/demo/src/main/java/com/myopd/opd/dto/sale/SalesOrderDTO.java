package com.myopd.opd.dto.sale;

import java.time.LocalDateTime;
import java.util.List;

public class SalesOrderDTO {
	private String firstName;
	private String lastName;
	private String email;
	private LocalDateTime dateOfPurchase;
	private List<OrderItemDTO> orderItems;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "SalesOrderDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfPurchase=" + dateOfPurchase + ", orderItems=" + orderItems + "]";
	}



}
