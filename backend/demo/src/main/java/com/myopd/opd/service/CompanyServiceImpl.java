package com.myopd.opd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myopd.opd.dao.CompanyDao;
import com.myopd.opd.dto.CompanyDTO;
import com.myopd.opd.entity.Company;
import com.myopd.opd.mapper.CompanyMapper;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyDao companyDao;
	private final CompanyMapper companyMapper;

	public CompanyServiceImpl(CompanyDao companyDao, CompanyMapper companyMapper) {
		this.companyDao = companyDao;
		this.companyMapper = companyMapper;
	}

	public List<CompanyDTO> getAllCompanies() {
		List<Company> companies = companyDao.findAll();
		return companies.stream().map(companyMapper::toDto).collect(Collectors.toList());

	}

}
