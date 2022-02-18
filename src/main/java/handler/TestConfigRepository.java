package handler;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.config.TestConfig;
import org.openqa.selenium.NotFoundException;

public class TestConfigRepository {

  private static final String PATH_TO_FILE = "test.config.json";

  private final ObjectMapper mapper;

  public TestConfigRepository() {
    this.mapper = new ObjectMapper();
    this.mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    this.mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
  }

  public TestConfig getTestConfig() {
    try {
      return mapper.readValue(getClass().getClassLoader().getResource(PATH_TO_FILE), new TypeReference<TestConfig>() {});
    } catch (IOException e) {
      throw new NotFoundException("Expected to have test properties read from file:  " + PATH_TO_FILE
          + "\nDetail message: " + e.getMessage());
    }
  }
}
