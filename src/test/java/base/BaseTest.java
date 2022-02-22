package base;

import java.util.logging.Level;

import base.testrail.TestRailExtension;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
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
import pages.MyAccountPage;
import pages.MyWishlistsPage;
import pages.OrderConfirmationPage;
import pages.PrintedSummerDressPage;
import pages.StartPage;
import service.AuthenticationService;
import utils.TestConfigSettings;

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
  private static final Logger LOG = Logger.getLogger(BaseTest.class);
  protected final String startMessageText = "Your order on My Store is complete.\n" +
      "Please send us a bank wire with\n" +
      "- Amount $28.00\n" +
      "- Name of account owner Pradeep Macharla\n" +
      "- Include these details xyz\n" +
      "- Bank name RTP\n" +
      "- Do not forget to insert your order reference";
  protected final String endsMessageText = "in the subject of your bank wire.\n" +
      "An email has been sent with this information.\n" +
      "Your order will be sent as soon as we receive payment.\n" +
      "If you have questions, comments or concerns, please contact our expert customer support team. .";

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
