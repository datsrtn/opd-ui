package com.myopd.opd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myopd.opd.entity.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
	Optional<Configuration> findByKey(String key);

}
