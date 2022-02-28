package tests;

import base.BaseTest;
import builders.CreateAccountBuilder;
import enums.ColorType;
import enums.SiteMessage;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TestClass extends BaseTest {

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

  @Epic("TESTING FOR http://automationpractice.com/ tasks")
  @Story("Check the possibility to order Casual dress by bank wire")
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
    myAccountPage.openCategoryDressesPage()
        .openCategoryCasualDressesPage()
        .hoverPrintedDress()
        .addToCart()
        .redirectToShoppingCart()
        .clickProceedToCheckoutButton()
        .clickProceedToCheckoutButton()
        .clickTermsOfServiceCheckbox()
        .clickProceedToCheckoutButton()
        .clickPayByBankWireButton()
        .clickIConfirmMyOrderButton();
    assertAll(
        () -> assertThat(orderConfirmationPage.informationBox(), startsWith(SiteMessage.START_MESSAGE_TEXT.getValue())),
        () -> assertThat(orderConfirmationPage.informationBox(), endsWith(SiteMessage.ENDS_MESSAGE_TEXT.getValue()))
    );
  }

  @Epic("TESTING FOR http://automationpractice.com/ tasks")
  @Story("Check the possibility to send email to Customer Service")
  @DisplayName("Check the possibility to send email to Customer Service")
  @Test
  public void checkSendEmailToCustomerService() {
    startPage.openLoginPage();
    authenticationService.createAccount(createAccountBuilder);
    myAccountPage.openCategoryDressesPage()
        .openCategoryCasualDressesPage()
        .hoverPrintedDress()
        .addToCart()
        .redirectToShoppingCart()
        .clickProceedToCheckoutButton()
        .clickProceedToCheckoutButton()
        .clickTermsOfServiceCheckbox()
        .clickProceedToCheckoutButton()
        .clickPayByBankWireButton()
        .clickIConfirmMyOrderButton();
    assertAll(
        () -> assertThat(orderConfirmationPage.informationBox(), startsWith(SiteMessage.START_MESSAGE_TEXT.getValue())),
        () -> assertThat(orderConfirmationPage.informationBox(), endsWith(SiteMessage.ENDS_MESSAGE_TEXT.getValue()))
    );

    orderConfirmationPage.clickContactUsButton()
        .pickContactCustomerService()
        .pickLastOrder()
        .pickLastProduct()
        .setMessageFieldOnField(SiteMessage.MESSAGE_TO_CUSTOMER_SERVICE.getValue())
        .clickSendButton();

    assertThat(
        "Your message has been successfully sent to our team.",
        CoreMatchers.equalTo(contactUsPage.getAlertMessage()));
  }

  @Epic("TESTING FOR http://automationpractice.com/ tasks")
  @Story("Check the possibility to write review about Faded Short Sleeve T-shirts")
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
        .setTitleField(SiteMessage.REVIEW_TITLE_MESSAGE.getValue())
        .setCommentField(SiteMessage.COMMENT_TO_REVIEW.getValue())
        .clickSendButton();
    assertThat(SiteMessage.MESSAGE_AFTER_REVIEW.getValue(), CoreMatchers.equalTo(fadedTShirtPage.getMessage()));
    fadedTShirtPage.clickOkButton();
  }

  @Epic("TESTING FOR http://automationpractice.com/ tasks")
  @Story("Check the possibility to add Blouse to wishlist")
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
    assertThat(SiteMessage.MESSAGE_AFTER_ADD_TO_WISHLIST.getValue(),
        CoreMatchers.equalTo(blouseClothesPage.getMessage()));
    blouseClothesPage.clickCloseMessageButton();
    assertThat(
        accountName,
        CoreMatchers.equalTo(blouseClothesPage.getAccountName()));
    blouseClothesPage.clickAccountName()
        .clickWishlistButton();
    myWishlistsPage.clickMyWishlistButton();
    assertThat(SiteMessage.QUANTITY_ON_WISHLIST.getValue(), CoreMatchers.equalTo(myWishlistsPage.getQuantity()));
    assertThat(SiteMessage.PRIORITY_ON_WISHLIST.getValue(), CoreMatchers.equalTo(myWishlistsPage.getPriority()));
    myWishlistsPage.clickDeleteButton();
  }

  @Epic("TESTING FOR http://automationpractice.com/ tasks")
  @Story("Check the possibility Printed Summer Dress page display for different colour dress")
  @DisplayName("Check the possibility Printed Summer Dress page display for different colour dress")
  @Test
  public void CheckDisplayDifferentColour() {
    startPage.hoverCategoryDresses()
        .clickSummerDressesCategory()
        .hoverFirstPrintedDress()
        .clickMoreButton();
    assertThat(printedSummerDressPage.getColorOrangeColorPick(), CoreMatchers.equalTo(ColorType.ORANGE.getRgba()));
    assertThat(printedSummerDressPage.getColorBlueColorPick(), CoreMatchers.equalTo(ColorType.BLUE.getRgba()));
    assertThat(printedSummerDressPage.getColorBlackColorPick(), CoreMatchers.equalTo(ColorType.BLACK.getRgba()));
    assertThat(printedSummerDressPage.getColorYellowColorPick(), CoreMatchers.equalTo(ColorType.YELLOW.getRgba()));
    assertThat(printedSummerDressPage.pickColorBlack()
        .getSrcMainImage(), CoreMatchers.equalTo(ColorType.BLACK.getSrc()));
    assertThat(printedSummerDressPage.pickColorBlue()
        .getSrcMainImage(), CoreMatchers.equalTo(ColorType.BLUE.getSrc()));
    assertThat(printedSummerDressPage.pickColorOrange()
        .getSrcMainImage(), CoreMatchers.equalTo(ColorType.ORANGE.getSrc()));
    assertThat(printedSummerDressPage.pickColorYellow()
        .getSrcMainImage(), CoreMatchers.equalTo(ColorType.YELLOW.getSrc()));
  }
}
