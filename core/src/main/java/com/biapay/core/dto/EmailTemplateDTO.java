package com.biapay.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EmailTemplateDTO {
  private Long emailTemplateId;

  @JsonProperty(access = Access.READ_ONLY)
  private String templateName;

  private String subject;

  private String content;

  @JsonProperty(access = Access.READ_ONLY)
  private LanguageDTO language;
}
