package com.biapay.core.dto.dashboard;

import java.util.List;

@FunctionalInterface
public interface DashboardItemCreator {

  List<DashBoardItem> build(long concernedObjectId);
}
