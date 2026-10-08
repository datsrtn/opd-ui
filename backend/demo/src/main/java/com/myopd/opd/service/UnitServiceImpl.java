package com.myopd.opd.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.myopd.opd.dao.UnitDao;
import com.myopd.opd.dto.UnitDTO;
import com.myopd.opd.entity.Unit;
import com.myopd.opd.mapper.UnitMapper;

@Service
public class UnitServiceImpl implements UnitService {

	
	private final UnitDao unitDao; 
	private final UnitMapper unitMapper;
	
	public UnitServiceImpl(UnitDao unitDao, UnitMapper unitMapper) {
        this.unitDao = unitDao;
        this.unitMapper = unitMapper;
    }
	
	public List<UnitDTO> getAllUnits() {
		 List<Unit> users = unitDao.findAll();
		 return users.stream()
	                .map(unitMapper::toDTO)
	                .collect(Collectors.toList());
	}
}
