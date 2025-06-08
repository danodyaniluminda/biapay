package com.biapay.core.dto;

import com.biapay.core.constant.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StreamMessageDTO {

  private MessageType type;
  private Object payload;
}
