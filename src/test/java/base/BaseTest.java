package base;

import base.testrail.TestRailExtension;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

import model.config.TestConfig;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BlouseClothesPage;
import pages.ContactUsPage;
import pages.FadedTShirtPage;
import pages.MyWishlistsPage;
import pages.OrderConfirmationPage;
import pages.PrintedSummerDressPage;
import pages.StartPage;
import service.AuthenticationService;
import service.OrderClothesService;
import utils.TestConfigSettings;

@ExtendWith({TestRailExtension.class})
public abstract class BaseTest {

  protected final StartPage startPage = new StartPage();
  protected final AuthenticationService authenticationService = new AuthenticationService();
  protected final OrderClothesService orderClothesService = new OrderClothesService();
  protected final OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
  protected final ContactUsPage contactUsPage = new ContactUsPage();
  protected final FadedTShirtPage fadedTShirtPage = new FadedTShirtPage();
  protected final BlouseClothesPage blouseClothesPage = new BlouseClothesPage();
  protected final MyWishlistsPage myWishlistsPage = new MyWishlistsPage();
  protected final PrintedSummerDressPage printedSummerDressPage = new PrintedSummerDressPage();
 public static final TestConfig CONFIG = TestConfigSettings.getInstance().getTestConfig();
  private static final Logger LOG = Logger.getLogger(BaseTest.class);

  @BeforeAll
  public static void setUp() {
    Configuration.browser = CONFIG.getBrowser();
    Configuration.browserSize = CONFIG.getBrowserSize();
    Configuration.headless = CONFIG.getHeadless();
    Configuration.baseUrl = CONFIG.getBaseUrl();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("incognito");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", CONFIG.getBrowser());
    capabilities.setCapability("enableVNC", CONFIG.getEnabledVnc());
    Configuration.remote = CONFIG.getRemoteUrl();
    Configuration.browserCapabilities = capabilities;
    LOG.fatal("fatal log");
    LOG.error("error log");
    LOG.warn("warn log");
    LOG.info("info log");
    LOG.debug("debug log");
  }

  @BeforeEach
  public void startTest() {
    SelenideLogger.addListener(
        "Allure", new AllureSelenide().screenshots(true).savePageSource(false));
    Selenide.open("/");
  }

  @AfterEach
  public void tearDown() {
    SelenideLogger.removeListener("Allure");
    Selenide.closeWindow();
  }
}
