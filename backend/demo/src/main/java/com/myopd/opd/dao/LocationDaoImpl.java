package com.myopd.opd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myopd.opd.entity.Location;
import com.myopd.opd.repository.LocationRepository;

@Repository
public class LocationDaoImpl implements LocationDao {

	private final LocationRepository locationRepository;

	public LocationDaoImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

}
