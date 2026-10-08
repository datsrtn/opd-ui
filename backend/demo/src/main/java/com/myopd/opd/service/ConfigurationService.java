package com.myopd.opd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import com.myopd.opd.entity.Configuration;
import com.myopd.opd.repository.ConfigurationRepository;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configRepository;

    @Cacheable("configValues")
    public String getConfigValue(String key) {
        Optional<Configuration> config = configRepository.findByKey(key);
        return config.map(Configuration::getValue).orElse(null);
    }
}