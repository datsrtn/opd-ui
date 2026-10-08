package com.myopd.opd.dto;

import java.util.Objects;

public class CompanyDTO {
	private long companyId;
	private String companyName;
	private String contactNumber;

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyId, companyName, contactNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyDTO other = (CompanyDTO) obj;
		return companyId == other.companyId && Objects.equals(companyName, other.companyName)
				&& Objects.equals(contactNumber, other.contactNumber);
	}

}
