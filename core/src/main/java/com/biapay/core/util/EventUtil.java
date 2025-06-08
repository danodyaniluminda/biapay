package com.biapay.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventUtil {
  private static ApplicationEventPublisher applicationEventPublisher;

  public EventUtil(ApplicationEventPublisher applicationEventPublisher) {
    EventUtil.applicationEventPublisher = applicationEventPublisher;
  }

  public static void publishEvent(Object o) {
    try {
      applicationEventPublisher.publishEvent(o);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
