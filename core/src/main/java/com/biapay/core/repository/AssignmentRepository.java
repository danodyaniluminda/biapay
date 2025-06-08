package com.biapay.core.repository;

import com.biapay.core.model.Assignment;
import com.biapay.core.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
  Optional<List<Assignment>> findByUser(User user);
}
