package com.myopd.opd.service;

import java.io.IOException;
import java.util.List;

import com.myopd.opd.dto.sale.SalesForExcelSheetDTO;

public interface ExcelService {
	 void appendSalesToExcel(
	            List<SalesForExcelSheetDTO> sales)
	            throws IOException;

	
}
