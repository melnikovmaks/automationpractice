package tests;

import base.BaseTest;
import builders.CreateAccountBuilder;
import enums.ColorType;
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
  CreateAccountBuilder createAccountBuilder = CreateAccountBuilder.builder()
      .firstName("Ivan")
      .lastName("Ivanov")
      .passwd("Qwerty123")
      .company("kaseya")
      .address("701 Brickell Avenue")
      .city("Miami")
      .postcode("33131")
      .additionalInformation("Additional information")
      .homePhone("+375292929297")
      .mobilePhone("+375333333333")
      .addressAlias("18, Baker street")
      .build();
  String messageToCustomerService = "I have a problem with my order. Could you help me";
  String commentToReview = "Faded short sleeve t-shirt with high neckline."
      + " Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!";
  String messageAfterReview = "Your comment has been added and will be available once approved by a moderator";
  String messageAfterAddToWishlist = "Added to your wishlist.";
  String reviewTitleMessage = "High quality product";
  String priorityOnWishlist = "Medium";
  String quantityOnWishlist = "1";

  @DisplayName("Check the possibility to order Casual dress by bank wire")
  @ParameterizedTest
  @CsvSource({"mfaiwdwwl@qq.q, Qwerty123"
  })
  public void checkOrderClothesByBankWire(
      String mail,
      String password
  ) {
    startPage.openLoginPage();
    authenticationService.loginOnSite(mail, password);
    orderClothesService.orderCasualDressByBankWire();
  }

  @DisplayName("Check the possibility to send email to Customer Service")
  @Test
  public void checkSendEmailToCustomerService() {
    startPage.openLoginPage();
    authenticationService.createAccount(createAccountBuilder);
    orderClothesService.orderCasualDressByBankWire();
    orderConfirmationPage.clickContactUsButton()
        .pickContactCustomerService()
        .pickLastOrder()
        .pickLastProduct()
        .setMessageFieldOnField(messageToCustomerService)
        .clickSendButton();

    assertEquals("Your message has been successfully sent to our team.", contactUsPage.getAlertMessage());
  }

  @DisplayName("Check the possibility to write review about Faded Short Sleeve T-shirts")
  @ParameterizedTest
  @CsvSource({"mfaiwdwwl@qq.q, Qwerty123"
  })
  public void checkWriteReview(
      String mail,
      String password
  ) {
    startPage.openLoginPage();
    authenticationService.loginOnSite(mail, password)
        .clickTShirtsButton()
        .hoverFadedTShirt()
        .clickMoreButton()
        .clickReviewButton()
        .pickQuality5Stars()
        .setTitleField(reviewTitleMessage)
        .setCommentField(commentToReview)
        .clickSendButton();
    assertEquals(messageAfterReview, fadedTShirtPage.getMessage());
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
    startPage.openLoginPage();
    authenticationService.loginOnSite(mail, password)
        .hoverCategoryWoman()
        .clickCategoryBlousesButton()
        .hoverFadedTShirt()
        .clickMoreButton()
        .clickWishlistButton();
    assertEquals(messageAfterAddToWishlist, blouseClothesPage.getMessage());
    blouseClothesPage.clickCloseMessageButton();
    assertEquals(
        accountName,
        blouseClothesPage.getAccountName());
    blouseClothesPage.clickAccountName()
        .clickWishlistButton();
    myWishlistsPage.clickMyWishlistButton();
    assertEquals(quantityOnWishlist, myWishlistsPage.getQuantity());
    assertEquals(priorityOnWishlist, myWishlistsPage.getPriority());
    myWishlistsPage.clickDeleteButton();
  }

  @DisplayName("Check the possibility Printed Summer Dress page display for different colour dress")
  @Test
  public void CheckDisplayDifferentColour() {
    startPage.hoverCategoryDresses()
        .clickSummerDressesCategory()
        .hoverFirstPrintedDress()
        .clickMoreButton();
    assertEquals(printedSummerDressPage.getColorOrangeColorPick(), ColorType.ORANGE.getRba());
    assertEquals(printedSummerDressPage.getColorBlueColorPick(), ColorType.BLUE.getRba());
    assertEquals(printedSummerDressPage.getColorBlackColorPick(), ColorType.BLACK.getRba());
    assertEquals(printedSummerDressPage.getColorYellowColorPick(), ColorType.YELLOW.getRba());
    assertEquals(printedSummerDressPage.pickColorBlack()
        .getSrcMainImage(), ColorType.BLACK.getSrc());
    assertEquals(printedSummerDressPage.pickColorBlue()
        .getSrcMainImage(), ColorType.BLUE.getSrc());
    assertEquals(printedSummerDressPage.pickColorOrange()
        .getSrcMainImage(), ColorType.ORANGE.getSrc());
    assertEquals(printedSummerDressPage.pickColorYellow()
        .getSrcMainImage(), ColorType.YELLOW.getSrc());
  }
}