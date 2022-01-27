package data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "selenium_timeout", "fake_base"})
public class TestConfig {

  @JsonProperty("base")
  private String baseUrl;

  @JsonProperty("fake_base")
  private String fakeBaseUrl;

  @JsonProperty("selenium_screenshots")
  boolean screenshots;

  @JsonProperty("selenium_browser")
  String browser;

  @JsonProperty("selenium_timeout")
  String timeout;

  @JsonProperty("selenium_headless")
  boolean headless;

  @JsonProperty("selenium_remote_url")
  String remoteUrl;

  @JsonProperty("selenium_vnc")
  boolean enableVNC;

  @JsonProperty("selenium_browser_size")
  String browserSize;

  @JsonProperty("options_arguments")
  String optionsArguments;
}
