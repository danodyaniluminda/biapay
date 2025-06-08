package com.biapay.core.repository;

import com.biapay.core.model.QrCodeModel;
import org.springframework.data.repository.CrudRepository;

public interface QrCodeRepository extends CrudRepository<QrCodeModel, Long> {

  QrCodeModel findByuserName(String string);
}
