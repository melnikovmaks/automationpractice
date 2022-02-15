package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;

/**
 * This class is made for making screenshots. To make screenshots, just call ScreenShooter.shoot()
 * It will automatically take a picture and attach it to the Allure report.
 */
public class ScreenShooter {

  private static final String PATH = "build/reports/tests/";
  private static final String END = ".png";

  private ScreenShooter() {
  }

  /**
   * Takes a screenshot and attaches it to Allure report.
   *
   * @throws IOException
   */
  public static void shoot() throws IOException {
    String fileName =
        new Date().toString()
            + " "
            + Thread.currentThread().getStackTrace()[2].getClassName()
            + " "
            + Thread.currentThread().getStackTrace()[2].getMethodName();

    Selenide.screenshot(fileName);

    File file = new File(PATH + fileName + END);
    byte[] array = Files.toByteArray(file);

    saveScreenshot(array);
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  private static byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }
}
