package com.myopd.opd.dto;

import java.util.List;

public class LocationsDetailsDTO {
	
    private String locationName;

    /** Derived field (sum of medicine quantities) */
    private Integer totalCrateQuantity;

    private List<LocationMedicineDTO> medicines;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getTotalCrateQuantity() {
		return totalCrateQuantity;
	}

	public void calculateTotalQuantity() {
        this.totalCrateQuantity = medicines == null
                ? 0
                : medicines.stream()
                           .mapToInt(LocationMedicineDTO::getQuantity)
                           .sum();
    }

	public List<LocationMedicineDTO> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<LocationMedicineDTO> medicines) {
		this.medicines = medicines;
	}
}
