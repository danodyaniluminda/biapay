package com.biapay.core.repository;

import com.biapay.core.model.Upload;
import com.biapay.core.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {
  Optional<Upload> findUploadByUuid(String uuid);

  Optional<Upload> findUploadByFileName(String fileName);

  List<Upload> findAllByUser(User user);

  void deleteUploadByUuid(String uuid);
}
