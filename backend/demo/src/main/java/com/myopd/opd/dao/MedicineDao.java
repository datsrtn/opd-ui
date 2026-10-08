package com.myopd.opd.dao;

import java.util.List;

import com.myopd.opd.entity.Medicine;

public interface MedicineDao {
	
	List<Medicine> findAll();

}
