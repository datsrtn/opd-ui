package com.myopd.opd.stock.dto;

import java.util.List;

public class FilterOptionsDTO {
	private List<IdNameDTO> locations;
	private List<IdNameDTO> medicines;
	private List<IdNameDTO> companies;
	public FilterOptionsDTO(List<IdNameDTO> locations, List<IdNameDTO> medicines, List<IdNameDTO> companies) {
		this.locations = locations;
		this.medicines = medicines;
		this.companies = companies;
	}
	public List<IdNameDTO> getLocations() {
		return locations;
	}
	public void setLocations(List<IdNameDTO> locations) {
		this.locations = locations;
	}
	public List<IdNameDTO> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<IdNameDTO> medicines) {
		this.medicines = medicines;
	}
	public List<IdNameDTO> getCompanies() {
		return companies;
	}
	public void setCompanies(List<IdNameDTO> companies) {
		this.companies = companies;
	}
	@Override
	public String toString() {
		return "FilterOptionsDTO [locations=" + locations + ", medicines=" + medicines + ", companies=" + companies
				+ "]";
	}
}
