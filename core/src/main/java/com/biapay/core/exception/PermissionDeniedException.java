package com.biapay.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "PermissionDeniedException not found")
public class PermissionDeniedException extends RuntimeException {
  private static final long serialVersionUID = 1000L;

  private String resourceName;
  private String fieldName;
  private Object fieldValue;

  public PermissionDeniedException(String message) {
    super(message);
  }

  public PermissionDeniedException(String message, Throwable cause) {
    super(message, cause);
  }

  public PermissionDeniedException(String resourceName, String fieldName, Object fieldValue) {
    super(String.format("%s access denied %s : '%s'", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }
}
