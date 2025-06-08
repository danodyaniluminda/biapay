package com.biapay.core.repository;

import com.biapay.core.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
  Setting findByName(String name);
}
