package service;

import java.util.Random;

public class RandomMailService {

  public String mailRandom() {
    String letters = "abcdefghijklmnopqrstuvwxyz";
    char[] chArray = letters.toCharArray();
    Random random = new Random();
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < 10; i++) {
      buffer.append(chArray[random.nextInt(chArray.length)]);
    }
    buffer.append("@gmail.com");
    return buffer.toString();
  }
}
