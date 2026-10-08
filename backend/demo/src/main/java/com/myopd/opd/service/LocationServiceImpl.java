package com.myopd.opd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myopd.opd.dao.LocationDao;
import com.myopd.opd.dto.LocationDTO;
import com.myopd.opd.entity.Location;
import com.myopd.opd.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService {

	private final LocationDao locationDao;
	private final LocationMapper locationMapper;

	public LocationServiceImpl(LocationDao locationDao, LocationMapper locationMapper) {
		this.locationDao = locationDao;
		this.locationMapper = locationMapper;
	}

	public List<LocationDTO> getAllLocations() {
		List<Location> locations = locationDao.findAll();

		return locations.stream()
				.map(locationMapper::toDTO)
				.collect(Collectors.toList());
	}

}
