package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BlouseClothesPage;
import pages.ContactUsPage;
import pages.FadedTShirtPage;
import pages.MyWishlistsPage;
import pages.OrderConfirmationPage;
import pages.PrintedSummerDressPage;
import pages.StartPage;
import service.AuthenticationService;
import service.OrderClothesService;

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
