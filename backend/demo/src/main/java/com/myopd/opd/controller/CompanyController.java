package com.myopd.opd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myopd.opd.dto.CompanyDTO;
import com.myopd.opd.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	private final CompanyService companyService;
	
	public CompanyController(CompanyService comapanyService) {
		this.companyService = comapanyService;
	}
	
	@GetMapping("/all")
	public List<CompanyDTO> getAllCompanies() {
		return companyService.getAllCompanies();
	}

}
