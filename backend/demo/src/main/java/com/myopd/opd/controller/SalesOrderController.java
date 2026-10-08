package com.myopd.opd.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myopd.opd.dto.sale.SalesForExcelSheetDTO;
import com.myopd.opd.dto.sale.SalesOrderDTO;
import com.myopd.opd.entity.SalesOrder;
import com.myopd.opd.repository.MedicineRepository;
import com.myopd.opd.service.CsvGeneratorService;
import com.myopd.opd.service.ExcelService;
import com.myopd.opd.service.SalesOrderService;

@RestController
@RequestMapping("/api/sales-orders")

public class SalesOrderController {
	private final SalesOrderService salesOrderService;
    private final CsvGeneratorService csvGeneratorService;
    private final ExcelService excelService;


	public SalesOrderController(SalesOrderService salesOrderService, CsvGeneratorService csvGeneratorService,ExcelService excelService) {
		this.salesOrderService = salesOrderService;
		this.csvGeneratorService = csvGeneratorService;
		this.excelService = excelService;

	}

	@PostMapping
	public   SalesOrder createOrder(@RequestBody SalesOrderDTO salesOrderDTO) {
		
		System.out.println("here");
		
		System.out.println("SalesOrderDTO: " + salesOrderDTO);
		
		SalesOrder savedOrder = salesOrderService.saveOrder(salesOrderDTO);
		System.out.println("pritning save ORder If "+savedOrder.getId());
		return savedOrder;
	}

	@GetMapping("/by-date")
	public ResponseEntity<List<SalesOrder>> getOrdersByDate(@RequestParam String date) {
		List<SalesOrder> orders = salesOrderService.getOrdersByDate(LocalDate.parse(date));
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping
    public ResponseEntity<List<SalesOrder>> getAllOrders() {
        List<SalesOrder> orders = salesOrderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
	 @GetMapping("/{id}/csv")
	    public ResponseEntity<byte[]> generateSalesOrderCsv(@PathVariable Long id) throws IOException {
	        Optional<SalesOrder> salesOrder = salesOrderService.getSalesOrderById(id);

	        if (salesOrder.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        byte[] csvBytes = csvGeneratorService.generateSalesOrderCsv(salesOrder.get());

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sales_order_" + id + ".csv")
	                .contentType(MediaType.TEXT_PLAIN)
	                .body(csvBytes);
	    }
	    
	    @GetMapping("/medicine-sales-report")
	    public List<SalesForExcelSheetDTO> getMedicineSalesReport(
	            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	            LocalDate fromDate,

	            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	            LocalDate toDate) {

	    	List<SalesForExcelSheetDTO> tmp  = salesOrderService.getMedicineSalesReport(fromDate, toDate);
	    	try {
				excelService.appendSalesToExcel(tmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return tmp;
	        
	        
	        
	        
	    }
	    
	    
	    
	    
}
