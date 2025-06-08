package com.biapay.core.repository;


import com.biapay.core.model.Account;
import com.biapay.core.model.User;
import com.biapay.core.model.UserType;
import com.biapay.core.model.enums.AccountSubType;
import com.biapay.core.model.enums.AccountType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {

  List<Account> findAccountByAccountUserTypeAndAccountUserId(UserType userType, Long userId);

  List<Account> findAccountByAccountUserTypeAndAccountUserIdAndAccountTypeAndAccountSubType(UserType userType, Long userId,
      AccountType accountType, AccountSubType accountSubType);

  List<Account> findAccountByAccountUserIdAndAccountTypeAndAccountSubType(Long accountUserId,
      AccountType accountType, AccountSubType accountSubType);

  int countByCurrencyCodeAndAccountUserTypeAndAccountUserId(String currencyCode,
      UserType accountUserType, Long accountUserId);

  boolean existsByCurrencyCodeAndAccountUserTypeAndAccountUserId(String currencyCode,
      UserType accountUserType, Long accountUserId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountUserId(String currencyCode,
      AccountType accountType, Long accountUserId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountSubTypeAndAccountUserId(String currencyCode,
      AccountType accountType, AccountSubType accountSubType, Long accountUserId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountUserIdAndSettlementMethodId(
      String currencyCode, AccountType accountType, Long accountUserId, Long settlementMethodId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountSubTypeAndAccountUserIdAndSettlementMethodId(
      String currencyCode, AccountType accountType, AccountSubType accountSubType,
      Long accountUserId, Long settlementMethodId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountUserIdAndPaymentMethodId(String currencyCode,
      AccountType accountType, Long accountUserId, Long paymentMethodId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountSubTypeAndAccountUserIdAndPaymentMethodId(
      String currencyCode, AccountType accountType, AccountSubType accountSubType,
      Long accountUserId, Long paymentMethodId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountSubTypeAndSettlementMethodId(
      String currencyCode, AccountType accountType, AccountSubType accountSubType,
      Long settlementMethodId);

  boolean existsByCurrencyCodeAndAccountTypeAndAccountSubTypeAndPaymentMethodId(String currencyCode,
      AccountType accountType, AccountSubType accountSubType, Long paymentMethodId);

  boolean existsByAccountNumber(String accountNumber);

  boolean existsByAccountNumberAndAccountUserType(String accountNumber, UserType accountUserType);

  boolean existsByAccountUserIdAndCurrencyCodeAndAccountTypeAndAccountSubTypeAndAccountNumberAndSettlementMethodId(Long accountUserId,
      String currencyCode, AccountType accountType, AccountSubType accountSubType, String accountNumber, Long settlementMethodId);

  List<Account> findAllByAccountUserIdAndAccountUserType(Long accountUserId,
      UserType accountUserType);

  List<Account> findAllByAccountUserIdAndAccountUserTypeAndAccountType(Long accountUserId,
      UserType accountUserType, AccountType accountType);

  Optional<Account> findByCurrencyCodeAndAccountUserTypeAndAccountUserId(String currencyCode,
      UserType accountUserType, Long accountUserId);

  Optional<Account> findFirstByCurrencyCodeAndAccountType(String currencyCode,
      AccountType accountType);

  Optional<Account> findByCurrencyCodeAndAccountUserTypeAndAccountUserIdAndAccountType(
      String currencyCode, UserType accountUserType, Long accountUserId, AccountType accountType);

  Account findFirstByCurrencyCodeAndAccountUserTypeAndAccountUserId(String currencyCode,
      UserType accountUserType, Long accountUserId);

  Optional<Account> findFirstByCurrencyCodeAndAccountUserTypeAndAccountUserIdAndAccountType(
      String currencyCode, UserType accountUserType, Long accountUserId,
      AccountType accountType);

  List<Account> findAccountsByAccountUserId(Long accountUserId);

  List<Account> findAccountsByAccountUserIdAndCurrencyCode(Long accountUserId, String currency);


  @Query(
      "update Account account set account.accountUserId = :newAccountUserId where account.accountUserId = :oldAccountUserId and account.accountUserType = :accountUserType")
  int updateAccount(Long newAccountUserId, Long oldAccountUserId, UserType accountUserType);

  Optional<Account> findFirstByAccountUserId(Long accountUserId);

  Optional<Account> findFirstByAccountNumber(String accountNumber);

  Optional<List<Account>> findAllByAccountNumber(String accountNumber);

  @Query(value = "from User u where u.userId not in (select a.accountUserId from Account a )")
  List<User> getPendingUsersForAccountCreation();

  Account findFirstByAccountIdAndCurrencyCode(Long accountId, String currencyCode);

  Optional<Account> findByCurrencyCodeAndAccountUserId(String currencyCode, Long accountUserId);

  Optional<Account> findFirstByCurrencyCodeAndAccountTypeAndAccountUserId(String currencyCode,
      AccountType accountType, Long userId);

  Optional<Account> findByCurrencyCodeAndAccountTypeAndSettlementMethodId(String currencyCode,
      AccountType accountType, Long settlementMethodId);

  List<Account> findByAccountType(AccountType accountType);

  List<Account> findByAccountTypeAndAccountUserId(AccountType accountType, Long userId);

  List<Account> findByAccountTypeAndAccountSubType(AccountType accountType,
      AccountSubType accountSubType);

  List<Account> findByAccountTypeAndAccountSubTypeAndPaymentMethodId(AccountType accountType,
      AccountSubType accountSubType, Long paymentMethodId);

  List<Account> findByAccountTypeAndAccountSubTypeAndSettlementMethodId(AccountType accountType,
      AccountSubType accountSubType, Long settlementMethodId);

  Optional<Account> findByAccountUserIdAndAccountTypeAndCurrencyCodeAndPosId(Long accountUserId, AccountType accountType, String currencyCode, Long posId);


//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.currencyCode = :currencyCode and a.accountType = :accountType")
  Optional<Account> findAccountForUpdate(@Param("currencyCode") String currencyCode,
      @Param("accountType") AccountType accountType);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.currencyCode = :currencyCode and a.accountType = :accountType and a.accountSubType = :accountSubType")
  Optional<Account> findAccountForUpdate(@Param("currencyCode") String currencyCode,
      @Param("accountType") AccountType accountType,
      @Param("accountSubType") AccountSubType accountSubType);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = :accountType")
  Optional<Account> findAccountForUpdate(@Param("accountUserId") Long accountUserId,
      @Param("currencyCode") String currencyCode, @Param("accountType") AccountType accountType);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = :accountType and a.posId = :posId")
  Optional<Account> findAccountForUpdate(@Param("accountUserId") Long accountUserId,
      @Param("currencyCode") String currencyCode, @Param("accountType") AccountType accountType,
      @Param("posId") Long posId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = :accountType and a.accountSubType = :accountSubType")
  Optional<Account> findAccountForUpdate(@Param("accountUserId") Long accountUserId,
      @Param("currencyCode") String currencyCode, @Param("accountType") AccountType accountType,
      @Param("accountSubType") AccountSubType accountSubType);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = :accountType and a.accountSubType = :accountSubType and a.paymentMethodId = :paymentMethodId")
  Optional<Account> findCollectionAccountForUpdate(@Param("accountUserId") Long accountUserId,
      @Param("currencyCode") String currencyCode, @Param("accountType") AccountType accountType,
      @Param("accountSubType") AccountSubType accountSubType,
      @Param("paymentMethodId") Long paymentMethodId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = :accountType and a.accountSubType = :accountSubType and a.settlementMethodId = :settlementMethodId")
  Optional<Account> findDisbursementAccountForUpdate(@Param("accountUserId") Long accountUserId,
      @Param("currencyCode") String currencyCode, @Param("accountType") AccountType accountType,
      @Param("accountSubType") AccountSubType accountSubType,
      @Param("settlementMethodId") Long settlementMethodId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.currencyCode = :currencyCode and a.accountType = 'SETTLEMENT' and a.accountSubType = 'COLLECTION' and a.paymentMethodId = :paymentMethodId")
  Optional<Account> findSettlementCollectionAccountForUpdate(
      @Param("currencyCode") String currencyCode, @Param("paymentMethodId") Long paymentMethodId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.currencyCode = :currencyCode and a.accountType = 'SETTLEMENT' and a.accountSubType = 'WITHDRAWAL' and a.settlementMethodId = :settlementMethodId")
  Optional<Account> findSettlementDisbursementAccountForUpdate(
      @Param("currencyCode") String currencyCode,
      @Param("settlementMethodId") Long settlementMethodId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.currencyCode = :currencyCode and a.accountType = 'PSP_FEE' and a.accountSubType = 'COLLECTION' and a.paymentMethodId = :paymentMethodId")
  Optional<Account> findPSPCollectionAccountForUpdate(@Param("currencyCode") String currencyCode,
      @Param("paymentMethodId") Long paymentMethodId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT a FROM Account a WHERE a.currencyCode = :currencyCode and a.accountType = 'PSP_FEE' and a.accountSubType = 'WITHDRAWAL' and a.settlementMethodId = :settlementMethodId")
  Optional<Account> findPSPDisbursementAccountForUpdate(@Param("currencyCode") String currencyCode,
      @Param("settlementMethodId") Long settlementMethodId);

  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = 'MERCHANT' and a.accountSubType = 'COLLECTION' and a.posId = :posId")
  Optional<Account> findMerchantCollectionAccount(@Param("accountUserId") Long accountUserId,
      @Param("currencyCode") String currencyCode, @Param("posId") Long posId);

  @Query("SELECT a FROM Account a WHERE a.accountUserId = :accountUserId and a.currencyCode = :currencyCode and a.accountType = 'MERCHANT' and a.accountSubType = 'COLLECTION'")
  List<Account> findMerchantCollectionAccount(@Param("accountUserId") Long accountUserId, @Param("currencyCode") String currencyCode);

}
