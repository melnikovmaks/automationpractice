package base;

import java.util.logging.Level;

import base.testrail.TestRailExtension;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import model.config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BlouseClothesPage;
import pages.ContactUsPage;
import pages.FadedTShirtPage;
import pages.MyAccountPage;
import pages.MyWishlistsPage;
import pages.OrderConfirmationPage;
import pages.PrintedSummerDressPage;
import pages.StartPage;
import service.AuthenticationService;
import utils.TestConfigSettings;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

@ExtendWith({TestRailExtension.class})
public abstract class BaseTest {

  private static final String ALLURE = "Allure";

  protected final StartPage startPage = new StartPage();
  protected final MyAccountPage myAccountPage = new MyAccountPage();
  protected final AuthenticationService authenticationService = new AuthenticationService();
  protected final OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
  protected final ContactUsPage contactUsPage = new ContactUsPage();
  protected final FadedTShirtPage fadedTShirtPage = new FadedTShirtPage();
  protected final BlouseClothesPage blouseClothesPage = new BlouseClothesPage();
  protected final MyWishlistsPage myWishlistsPage = new MyWishlistsPage();
  protected final PrintedSummerDressPage printedSummerDressPage = new PrintedSummerDressPage();
  public static final TestConfig CONFIG = TestConfigSettings.getInstance().getTestConfig();

  @BeforeAll
  public static void setUp() {
    Configuration.baseUrl = CONFIG.getBaseUrl();
    Configuration.timeout = CONFIG.getTimeout();
    Configuration.browserVersion = CONFIG.getBrowserVersion();
    Configuration.browser = CONFIG.getBrowser();
    Configuration.browserSize = CONFIG.getBrowserSize();
    Configuration.headless = CONFIG.getHeadless();
    Configuration.savePageSource = CONFIG.getSelenideSavePageSource();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    if (CONFIG.isRemoteType()) {
      Configuration.remote = CONFIG.getRemoteUrl();
    }
    if (CONFIG.getBrowser().equals("firefox")) {
      capabilities.setBrowserName(FIREFOX);
      final FirefoxOptions options = new FirefoxOptions().addArguments("private");
      capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
    }
    if (CONFIG.getBrowser().equals("chrome")) {
      capabilities.setBrowserName(CHROME);
      final ChromeOptions options = new ChromeOptions().addArguments("incognito");
      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }
    capabilities.setCapability("enableVNC", CONFIG.getEnabledVnc());
    Configuration.fastSetValue = true;
    Configuration.browserCapabilities = capabilities;
  }

  @BeforeEach
  public void begin() {
    SelenideLogger.addListener(ALLURE, new AllureSelenide()
        .savePageSource(CONFIG.getSelenideSavePageSource())
        .screenshots(CONFIG.getSelenideScreenshots())
        .enableLogs(LogType.BROWSER, Level.SEVERE)
        .enableLogs(LogType.CLIENT, Level.SEVERE)
        .enableLogs(LogType.SERVER, Level.SEVERE)
        .enableLogs(LogType.PERFORMANCE, Level.SEVERE));
    Selenide.open("/");
  }

  @AfterEach
  public void tearDown() {
    SelenideLogger.removeListener("Allure");
    Selenide.closeWindow();
  }
}
