package com.biapay.core.service;

import com.biapay.core.dto.DailySummaryDto;
import com.biapay.core.model.enums.AccountEventType;
import com.biapay.core.model.enums.AccountType;
import com.biapay.core.repository.AccountEventRepository;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Tuple;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AccountCoreService {
  private final AccountEventRepository accountEventRepository;

  public List<DailySummaryDto> prepareDailySummary(AccountEventType accountEventType,
      AccountType accountType) {
    // Fetching the result as a List of Tuple
    List<Tuple> result = accountEventRepository.getDailyTotalAmountSummary(
        accountEventType.name(), accountType.name());

    // Mapping Tuple to DTO
    return  result.stream().map(tuple -> {
      // Extracting values from the Tuple
      Date transactionDateSql = tuple.get("transaction_date", Date.class);
      BigDecimal totalAmount = tuple.get("total_amount", BigDecimal.class);

      // Converting java.sql.Date to LocalDate
      LocalDate transactionDate = transactionDateSql.toLocalDate();

      // Creating and returning DailySummaryDto
      return new DailySummaryDto(transactionDate, totalAmount);
    }).collect(Collectors.toList());

  }
}
