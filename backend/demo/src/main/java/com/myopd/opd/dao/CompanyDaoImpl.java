package com.myopd.opd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myopd.opd.entity.Company;
import com.myopd.opd.repository.CompanyRepository;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	private final CompanyRepository companyRepository;

	public CompanyDaoImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;

	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

}
