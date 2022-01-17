package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.BlouseClothesPage;
import pages.ContactUsPage;
import pages.FadedTShirtPage;
import pages.MyWishlistsPage;
import pages.OrderConfirmationPage;
import pages.PrintedSummerDressPage;
import pages.StartPage;
import service.AuthenticationService;
import service.OrderClothesService;

import static org.testng.Assert.assertEquals;

public class TestClass extends BaseTest {

  StartPage startPage = new StartPage();
  AuthenticationService authenticationService = new AuthenticationService();
  OrderClothesService orderClothesService = new OrderClothesService();
  OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
  ContactUsPage contactUsPage = new ContactUsPage();
  FadedTShirtPage fadedTShirtPage = new FadedTShirtPage();
  BlouseClothesPage blouseClothesPage = new BlouseClothesPage();
  MyWishlistsPage myWishlistsPage = new MyWishlistsPage();
  PrintedSummerDressPage printedSummerDressPage = new PrintedSummerDressPage();

  @DisplayName("Check the possibility to order Casual dress by bank wire")
  @ParameterizedTest
  @CsvSource({"mfaiwdwwl@qq.q, Qwerty123"
  })
  public void checkOrderClothesByBankWire(
      String mail,
      String password
  ) {
    startPage.open()
        .openLoginPage();
    authenticationService.loginOnSite(mail, password);
    orderClothesService.orderCasualDressByBankWire();
  }

  @Test
  @DisplayName("Check the possibility to send email to Customer Service")
  public void checkSendEmailToCustomerService() {
    startPage.open()
        .openLoginPage();
    authenticationService.createAccount();
    orderClothesService.orderCasualDressByBankWire();
    orderConfirmationPage.clickContactUsButton()
        .pickContactCustomerService()
        .pickLastOrder()
        .pickLastProduct()
        .setMessageFieldOnField("I have a problem with my order. Could you help me")
        .clickSendButton();
    assertEquals(
        "Your message has been successfully sent to our team.",
        contactUsPage.getAlertMessage());
  }

  @DisplayName("Check the possibility to write review about Faded Short Sleeve T-shirts")
  @ParameterizedTest
  @CsvSource({"mfaiwdwwl@qq.q, Qwerty123"
  })
  public void checkWriteReview(
      String mail,
      String password
  ) {
    startPage.open()
        .openLoginPage();
    authenticationService.loginOnSite(mail, password)
        .clickTShirtsButton()
        .hoverFadedTShirt()
        .clickMoreButton()
        .clickReviewButton()
        .pickQuality5Stars()
        .setTitleField("High quality product")
        .setCommentField(
            "Faded short sleeve t-shirt with high neckline. Soft and stretchy material for a comfortable fit." +
                " Accessorize with a straw hat and you're ready for summer!")
        .clickSendButton();
    assertEquals(
        "Your comment has been added and will be available once approved by a moderator",
        fadedTShirtPage.getMessage());
    fadedTShirtPage.clickOkButton();
  }

  @DisplayName("Check the possibility to add Blouse to wishlist")
  @ParameterizedTest
  @CsvSource({"mfaiwdwwl@qq.q, Qwerty123, Ivan Ivanov"
  })
  public void checkAddToWishlist(
      String mail,
      String password,
      String accountName
  ) {
    startPage.open()
        .openLoginPage();
    authenticationService.loginOnSite(mail, password)
        .hoverCategoryWoman()
        .clickCategoryBlousesButton()
        .hoverFadedTShirt()
        .clickMoreButton()
        .clickWishlistButton();
    assertEquals(
        "Added to your wishlist.",
        blouseClothesPage.getMessage());
    blouseClothesPage.clickCloseMessageButton();
    assertEquals(
        accountName,
        blouseClothesPage.getAccountName());
    blouseClothesPage.clickAccountName()
        .clickWishlistButton();
    myWishlistsPage.clickMyWishlistButton();
    assertEquals(
        "1",
        myWishlistsPage.getQuantity());
    assertEquals(
        "Medium",
        myWishlistsPage.getPriority());
    myWishlistsPage.clickDeleteButton();
  }

  @DisplayName("Check the possibility Printed Summer Dress page display for different colour dress")
  @Test
  public void CheckDisplayDifferentColour() {
    startPage.open()
        .hoverCategoryDresses()
        .clickSummerDressesCategory()
        .hoverFirstPrintedDress()
        .clickMoreButton();
    assertEquals(printedSummerDressPage.getColorOrangeColorPick(), "rgba(243, 156, 17, 1)");
    assertEquals(printedSummerDressPage.getColorBlueColorPick(), "rgba(93, 156, 236, 1)");
    assertEquals(printedSummerDressPage.getColorBlackColorPick(), "rgba(67, 74, 84, 1)");
    assertEquals(printedSummerDressPage.getColorYellowColorPick(), "rgba(241, 196, 15, 1)");
    assertEquals(printedSummerDressPage.pickColorBlack()
        .getSrcMainImage(), "http://automationpractice.com/img/p/1/5/15-large_default.jpg");
    assertEquals(printedSummerDressPage.pickColorBlue()
        .getSrcMainImage(), "http://automationpractice.com/img/p/1/3/13-large_default.jpg");
    assertEquals(printedSummerDressPage.pickColorOrange()
        .getSrcMainImage(), "http://automationpractice.com/img/p/1/4/14-large_default.jpg");
    assertEquals(printedSummerDressPage.pickColorYellow()
        .getSrcMainImage(), "http://automationpractice.com/img/p/1/2/12-large_default.jpg");
  }
}
