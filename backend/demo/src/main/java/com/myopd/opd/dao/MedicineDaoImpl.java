package com.myopd.opd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myopd.opd.entity.Medicine;
import com.myopd.opd.repository.MedicineRepository;

@Repository
public class MedicineDaoImpl implements MedicineDao {
	
	private final MedicineRepository medicineRepository;
	
	public MedicineDaoImpl(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}

	@Override
	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}
	

}
