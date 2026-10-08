package com.myopd.opd.dao;

import java.util.List;

import com.myopd.opd.entity.Location;

public interface LocationDao {

	List<Location> findAll();

}
