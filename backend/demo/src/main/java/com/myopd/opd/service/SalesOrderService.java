package com.myopd.opd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.myopd.opd.dto.sale.SalesForExcelSheetDTO;
import com.myopd.opd.dto.sale.SalesOrderDTO;
import com.myopd.opd.entity.SalesOrder;

public interface SalesOrderService {
	SalesOrder saveOrder(SalesOrderDTO salesOrderDTO);

	List<SalesOrder> getOrdersByDate(LocalDate date);
	
	List<SalesOrder> getAllOrders();

	Optional<SalesOrder> getSalesOrderById(Long id);

	List<SalesForExcelSheetDTO> getMedicineSalesReport(LocalDate fromDate, LocalDate toDate);
}
