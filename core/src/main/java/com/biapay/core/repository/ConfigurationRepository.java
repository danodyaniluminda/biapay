package com.biapay.core.repository;

import com.biapay.core.model.Configuration;
import com.biapay.core.model.ConfigurationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, ConfigurationId> {
  Configuration findByConfigurationId(ConfigurationId configurationId);
}
