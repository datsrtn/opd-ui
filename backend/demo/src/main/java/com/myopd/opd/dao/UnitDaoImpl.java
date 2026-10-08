package com.myopd.opd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myopd.opd.entity.Unit;
import com.myopd.opd.repository.UnitRepository;

@Repository
public class UnitDaoImpl implements UnitDao {

	private final UnitRepository unitRepository;
	
	public UnitDaoImpl(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}

	@Override
	public List<Unit> findAll() {
		return unitRepository.findAll();
	}

}
