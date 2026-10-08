package com.myopd.opd.dao;

import java.util.List;
import com.myopd.opd.entity.Company;

/**
 * Basic interface for fetching data from the DB
 */
public interface CompanyDao {

	List<Company> findAll();

}
