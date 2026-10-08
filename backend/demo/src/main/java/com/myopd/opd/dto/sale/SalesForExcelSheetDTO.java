package com.myopd.opd.dto.sale;

import java.math.BigDecimal;
public interface SalesForExcelSheetDTO {

	 String getFirstName();
	 
	String getPurchaseDate();

    String getMedicineName();

    String getCompanyName();

    Long getTotalQuantity();

    BigDecimal getTotalSales();
}
