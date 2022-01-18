package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

  @BeforeAll
  public static void setUp() {
    Configuration.browser = "chrome";
    Configuration.screenshots = true;
    Configuration.browserSize = "1600x1000";
    Configuration.headless = false;
    Configuration.baseUrl = "http://automationpractice.com/";
    ChromeOptions options = new ChromeOptions();
    options.addArguments("incognito");
    Configuration.browserCapabilities = options;
  }

  @BeforeEach
  public void startTest() {
    Selenide.open("/");
  }

  @AfterEach
  public void tearDown() {
    System.out.println("@AfterEach executed");
    Selenide.closeWindow();
  }
}
