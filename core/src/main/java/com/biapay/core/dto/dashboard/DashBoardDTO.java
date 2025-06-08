package com.biapay.core.dto.dashboard;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DashBoardDTO {
  String dashBoardName;
  DashBoardItemValueType dashBoardItemValueType;
  long numberOfItems;
  List<DashBoardItem> dashBoardItems;

  public static DashBoardDTO createDashboard(
      List<DashBoardItem> items, String title, DashBoardItemValueType dashBoardItemValueType) {
    DashBoardDTO dashBoardDTO = new DashBoardDTO();
    dashBoardDTO.setDashBoardItemValueType(dashBoardItemValueType);
    dashBoardDTO.setDashBoardName(title);
    dashBoardDTO.setNumberOfItems(items.size());
    dashBoardDTO.setDashBoardItems(items);

    return dashBoardDTO;
  }

  public static DashBoardDTO createDashboard(
      String title,
      long concernedObjectId,
      DashboardItemCreator dashboardItemCreator,
      DashBoardItemValueType dashBoardItemValueType) {
    List<DashBoardItem> items = dashboardItemCreator.build(concernedObjectId);
    DashBoardDTO dashBoardDTO = new DashBoardDTO();
    dashBoardDTO.setDashBoardItemValueType(dashBoardItemValueType);
    dashBoardDTO.setDashBoardName(title);
    dashBoardDTO.setNumberOfItems(items.size());
    dashBoardDTO.setDashBoardItems(items);

    return dashBoardDTO;
  }
}
