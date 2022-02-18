package model.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.RunType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestConfig {

  @JsonProperty("base_url")
  private String baseUrl;

  @JsonProperty("remote_base_url")
  private String remoteBaseUrl;

  @JsonProperty("us_url")
  private String usa;

  @JsonProperty("us_google_url")
  private String usaGoogle;

  @JsonProperty("app_auth_paths")
  private String appAuthPaths;

  @JsonProperty("auth_path")
  private String authPath;

  @JsonProperty("k1_callback")
  private String k1Callback;

  @JsonProperty("rest_assured_base_path")
  private String basePath;

  @JsonProperty("test_rail_base_url")
  private String testRailUrl;

  @JsonProperty("test_rail_username")
  private String testRailUsername;

  @JsonProperty("test_rail_api_key")
  private String testRailApiKey;

  @JsonProperty("runType")
  private String runType;

  @JsonProperty("selenium_browser")
  private String browser;

  @JsonProperty("selenium_browser_version")
  private String browserVersion;

  @JsonProperty("selenium_timeout")
  private long timeout;

  @JsonProperty("selenium_headless")
  private Boolean headless;

  @JsonProperty("selenium_start_maximized")
  private Boolean startMaximized;

  @JsonProperty("selenium_remote_url")
  private String remoteUrl;

  @JsonProperty("selenide_screenshots")
  private Boolean selenideScreenshots;

  @JsonProperty("selenide_save_page_source")
  private Boolean selenideSavePageSource;

  @JsonProperty("selenium_browser_size_for_checking_element")
  private String browserSizeForCheckingElement;

  @JsonProperty("selenium_browser_size")
  private String browserSize;

  @JsonProperty("selenium_vnc")
  private Boolean enabledVnc;

  public boolean isRemoteType() {
    return RunType.REMOTE.getValue().equalsIgnoreCase(runType);
  }
}