package com.biapay.core.repository;

import com.biapay.core.model.SecurityQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Long> {
  List<SecurityQuestion> findByCode(String code);
}
