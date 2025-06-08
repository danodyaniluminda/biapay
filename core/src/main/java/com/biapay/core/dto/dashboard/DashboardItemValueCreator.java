package com.biapay.core.dto.dashboard;

import java.time.LocalDateTime;
import java.util.List;

@FunctionalInterface
public interface DashboardItemValueCreator {

  List<DashBoardItemValue> build(
      long concernedObjectId, String currency, LocalDateTime startDate, LocalDateTime endDate);
}
