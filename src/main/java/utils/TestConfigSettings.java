package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import handler.TestConfigRepository;
import model.config.TestConfig;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class TestConfigSettings {

  private static TestConfigSettings instance;

  private final TestConfig testConfig;
  private final JSONParser jsonParser;

  private TestConfigSettings() {
    final String browser = System.getProperty("browser");
    final String browserVersion = System.getProperty("browser.version");
    this.testConfig = new TestConfigRepository().getTestConfig();
    if (browser != null && browserVersion != null) {
      testConfig.setBrowser(browser);
      testConfig.setBrowserVersion(browserVersion);
    }
    this.jsonParser = new JSONParser();
  }

  public static TestConfigSettings getInstance() {
    if (instance == null) {
      instance = new TestConfigSettings();
    }
    return instance;
  }

  public TestConfig getTestConfig() {
    return testConfig;
  }

  public String getPath(final String path) {
    try {
      return jsonParser.parse(Files.readString(Path.of(path))).toString();
    } catch (ParseException | IOException e) {
      throw new RuntimeException("Failed to parse Json file\nPath: " + path);
    }
  }
}