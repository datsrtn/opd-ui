package com.myopd.opd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.myopd.opd.dto.CompanyDTO;
import com.myopd.opd.entity.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	CompanyDTO toDto(Company company);
	Company toCompany(CompanyDTO companyDto);

}
