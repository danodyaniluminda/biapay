package com.biapay.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppOTPMessage implements Serializable {
  private final String messaging_product = "whatsapp";
  private String to;
  private final String recipient_type = "individual";
  private final String type = "template";
  private Template template = new Template();

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Template {
    private final String name = "send_otp_biapay";

    @JsonProperty("language")
    private WhatsAppLanguage language = new WhatsAppLanguage();

    private ArrayList<Components> components = new ArrayList<>(List.of(new Components()));
  }

  @Data
  @AllArgsConstructor
  public static class WhatsAppLanguage {
    private final String code = "en";
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Components {
    private final String type = "body";
    private ArrayList<Parameter> parameters = new ArrayList<>(List.of(new Parameter()));
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Parameter {
    private final String type = "text";
    private String text;
  }
}
