package com.myopd.opd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myopd.opd.dto.LocationDTO;
import com.myopd.opd.service.LocationService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/locations")
public class LocationController {
	
	private final LocationService locationService;
	
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	  @GetMapping("/all")
	    public List<LocationDTO> getAllLocations() {
		  System.out.println("In location controller");
		  System.out.println(locationService.getAllLocations().size());
	        return locationService.getAllLocations();
	    }

}
