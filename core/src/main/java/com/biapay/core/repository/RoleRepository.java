package com.biapay.core.repository;

import com.biapay.core.model.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);

  @Query(
      "select role from Role role"
          + " left join fetch role.merchant merchant"
          + " where merchant.id = :merchantId")
  List<Role> findByMerchantId(Long merchantId);

  @Query("select role from Role role" + " where role.merchant is null ")
  List<Role> findByMerchantIdNull();

  Optional<Role> findByIdAndMerchantIsNull(Long id);

  Optional<Role> findByIdAndMerchant_Id(Long id, Long merchant_id);

}
