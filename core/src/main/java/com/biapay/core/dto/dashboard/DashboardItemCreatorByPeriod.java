package com.biapay.core.dto.dashboard;

import java.time.LocalDateTime;
import java.util.List;

@FunctionalInterface
public interface DashboardItemCreatorByPeriod {

  List<DashBoardItem> build(long concernedObjectId, LocalDateTime start, LocalDateTime end);
}
