package com.myopd.opd.dao;

import java.util.List;

import com.myopd.opd.entity.Unit;
/**
 * Basic interface for fetching data from the DB
 */
public interface UnitDao {

	List<Unit> findAll();

}
