package com.biapay.core.repository;

import com.biapay.core.model.BarCodeModel;
import org.springframework.data.repository.CrudRepository;

public interface BarCodeRepository extends CrudRepository<BarCodeModel, Long> {

  BarCodeModel findByuserName(BarCodeModel user);

  BarCodeModel findByuserName(String userName);
}
