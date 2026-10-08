package com.myopd.opd.stock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myopd.opd.entity.Medicine;
import com.myopd.opd.stock.dto.FilterOptionsDTO;
import com.myopd.opd.stock.dto.StockFilterRequest;
import com.myopd.opd.stock.service.StockService;

@RestController
@RequestMapping("/api/stock")

public class StockController {

    private final StockService stockService;
    
    public StockController(StockService stockService) {
		this.stockService = stockService;
	}

    @PostMapping("/filter-options")
    public FilterOptionsDTO getFilterOptions(
        @RequestBody StockFilterRequest request
    ) {
        return stockService.getFilterOptions(request);
    }

    @GetMapping("/entries")
    public List<Medicine> getStockEntries(
    		  @RequestParam Long locationId,
    		    @RequestParam String medicineName,
    		    @RequestParam Long companyId
    ) {
    	List<Medicine> retValue= stockService.getStockEntries(locationId, medicineName, companyId);
    	
    	for(Medicine med: retValue) {
			System.out.println(med);
		}
    	return retValue;
    }
}