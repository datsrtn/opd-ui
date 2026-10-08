package com.myopd.opd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myopd.opd.dto.UnitDTO;
import com.myopd.opd.service.UnitService;

@RestController
@RequestMapping("/api/units")
public class UnitController {
	
	private final UnitService unitService;
	
	public UnitController(UnitService unitService) {
		this.unitService = unitService;
	}
	
	
    @GetMapping("/all")
    public List<UnitDTO> getAllUsers() {
        return unitService.getAllUnits();
    }

}
