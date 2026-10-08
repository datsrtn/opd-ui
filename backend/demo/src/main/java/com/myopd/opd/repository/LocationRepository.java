package com.myopd.opd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myopd.opd.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
