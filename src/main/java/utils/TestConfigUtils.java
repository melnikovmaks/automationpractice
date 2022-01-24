package utils;

import data.model.TestConfig;
import repository.TestConfigRepository;

public class TestConfigUtils {

  private TestConfigUtils() {
  }

  public static TestConfig getTestConfig() {
    return new TestConfigRepository().getTestConfig();
  }
}
