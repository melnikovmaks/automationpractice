package repository;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data.model.TestConfig;
import exceptions.TestConfigException;

public class TestConfigRepository {

  private static final String PATH_TO_FILE = "test.config.json";

  public TestConfig getTestConfig() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);

    TestConfig testConfig;
    try {
      testConfig = mapper.readValue(
          getClass().getClassLoader().getResource(PATH_TO_FILE),
          new TypeReference<TestConfig>() {});
    } catch (IOException e) {
      e.getMessage();
      throw new TestConfigException("Expected to have test properties read from file:  " + PATH_TO_FILE);
    }
    return testConfig;
  }
}
