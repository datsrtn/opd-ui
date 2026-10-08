package com.myopd.opd.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myopd.opd.entity.Medicine;
import com.myopd.opd.stock.dto.FilterOptionsDTO;
import com.myopd.opd.stock.dto.StockFilterRequest;
import com.myopd.opd.stock.repository.StockRepository;
@Service
public class StockService {

    private final StockRepository repo;
    
    public StockService(StockRepository repo) {
		this.repo = repo;
	}

    public FilterOptionsDTO getFilterOptions(StockFilterRequest req) {
    	FilterOptionsDTO retValue = new FilterOptionsDTO(
    	
            repo.findLocations(req.getLocationId(),req.getCompanyId(), req.getMedicineName()),
            repo.findMedicines(req.getLocationId(), req.getCompanyId(),req.getMedicineName()),
            repo.findCompanies(req.getLocationId(), req.getMedicineName(),req.getCompanyId())
        );
    	
    	System.out.println("Filter Options Retrieved: " + retValue);
		return retValue;
        
        
        
    }

    public List<Medicine> getStockEntries(
        Long locationId,  String medicineName,Long companyId 
    ) {
    	 List<Medicine> retValue= repo.findStockEntries(locationId, companyId, medicineName);
        return retValue;
    }
}