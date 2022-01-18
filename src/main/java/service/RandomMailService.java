package service;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomMailService {

  public String mailRandom() {
    return RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
  }
}
