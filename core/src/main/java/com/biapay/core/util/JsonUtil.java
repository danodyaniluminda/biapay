package com.biapay.core.util;

import com.biapay.core.exception.BIAPayRuntimeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class JsonUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

  private static ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
  }

  public static <T> T toObject(Map map, Class<T> klass) {
    if (map == null) {
      return null;
    }
    return objectMapper.convertValue(map, klass);
  }

  public static <T> T stringObject(String jsonTring, Class<T> klass) {
    return objectMapper.convertValue(jsonTring, klass);
  }

  @SneakyThrows
  public static String toJsonString(Object o) {
    return objectMapper.writeValueAsString(o);
  }

  @SneakyThrows
  public static JsonNode jsonNode(String json) {
    return objectMapper.readTree(json);
  }

  @SneakyThrows
  public static <T> T toObject(JsonNode jsonNode, Class<T> klass) {
    return objectMapper.convertValue(jsonNode, klass);
  }

  public static Map<String, Object> toJson(String json) {
    try {
      return objectMapper.readValue(json, HashMap.class);
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      throw new BIAPayRuntimeException(e);
    }
  }

  public static <T> String serialize(T t) {
    try {
      return objectMapper.writeValueAsString(t);
    } catch (JsonProcessingException e) {
      LOGGER.error(e.getMessage(), e);
      throw new BIAPayRuntimeException(e);
    }
  }

  public static <T> T toObject(String jsonTring, Class<T> klass) {
    try {
      return objectMapper.readValue(jsonTring, klass);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
      throw new BIAPayRuntimeException(e);
    }
  }

  @SneakyThrows
  public static <T> T toObject(InputStream jsonTring, Class<T> klass) {
    return objectMapper.readValue(jsonTring, klass);
  }

  public static Map<String, Object> toMap(Object object) {
    return objectMapper.convertValue(object, Map.class);
  }
}
