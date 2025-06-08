package com.biapay.core.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<T> {
  private String responseCode;
  private String responseMsg;
  private boolean error;
  private T responseData;
}
