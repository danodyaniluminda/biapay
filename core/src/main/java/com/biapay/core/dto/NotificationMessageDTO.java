package com.biapay.core.dto;

import com.biapay.core.constant.MessageType;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessageDTO {
  private String locale;
  private String destination;
  private MessageType type;
  private Object payload;
  private String template;
  private String message;
  private long userId;
  private Map<String, Object> variables;
  private String fileLocation;

}
