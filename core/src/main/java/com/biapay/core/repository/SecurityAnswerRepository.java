package com.biapay.core.repository;

import com.biapay.core.model.SecurityAnswer;
import com.biapay.core.model.SecurityQuestion;
import com.biapay.core.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityAnswerRepository extends JpaRepository<SecurityAnswer, Long> {
  List<SecurityAnswer> findByQuestion(SecurityQuestion question);

  List<SecurityAnswer> findByUser(User user);
}
