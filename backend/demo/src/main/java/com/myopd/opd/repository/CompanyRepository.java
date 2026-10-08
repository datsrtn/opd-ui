package com.myopd.opd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myopd.opd.entity.Company;

public interface CompanyRepository extends  JpaRepository<Company, Integer>{

}
