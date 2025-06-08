package com.biapay.core.dto.dashboard;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DashboardGroup {
  private long groupId;
  private String groupName;
  private List<DashBoardDTO> dashboards;
}
