package com.biapay.core.dto;

import java.util.List;
import lombok.Data;

@Data
public class MerchantPosAccountDTO {
  private Long posId;
  private List<MerchantAccountBalanceDTO> merchantAccountBalanceDTO;
}
