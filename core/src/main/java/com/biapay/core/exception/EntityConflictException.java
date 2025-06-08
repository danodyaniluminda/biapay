package com.biapay.core.exception;

import java.util.ArrayList;
import java.util.List;

public class EntityConflictException extends RuntimeException{
  private String entityName;
  private String conflictWith;

  public EntityConflictException(String message) {
    super(message);
  }

  public EntityConflictException(String message, Throwable cause) {
    super(message, cause);
  }

  public EntityConflictException(String entityName, String conflictWith) {
    super(String.format("Entity %s conflicts with: %s ", entityName, conflictWith));
    this.entityName = entityName;
  }

  public String getEntityName() {
    return entityName;
  }

  public String getConflictWith() {
    return conflictWith;
  }
}
