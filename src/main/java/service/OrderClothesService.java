package service;

import pages.MyAccountPage;
import pages.OrderConfirmationPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderClothesService {

  MyAccountPage myAccountPage = new MyAccountPage();
  OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
  private final String startMessageText = "Your order on My Store is complete.\n" +
      "Please send us a bank wire with\n" +
      "- Amount $28.00\n" +
      "- Name of account owner Pradeep Macharla\n" +
      "- Include these details xyz\n" +
      "- Bank name RTP\n" +
      "- Do not forget to insert your order reference";
  private final String endsMessageText = "in the subject of your bank wire.\n" +
      "An email has been sent with this information.\n" +
      "Your order will be sent as soon as we receive payment.\n" +
      "If you have questions, comments or concerns, please contact our expert customer support team. .";

  public void orderCasualDressByBankWire() {
    myAccountPage.openCategoryDressesPage()
        .openCategoryCasualDressesPage()
        .hoverPrintedDress()
        .hoverPrintedDress().addToCart()
        .redirectToShoppingCart()
        .clickProceedToCheckoutButton()
        .clickProceedToCheckoutButton()
        .clickTermsOfServiceCheckbox()
        .clickProceedToCheckoutButton()
        .clickPayByBankWireButton()
        .clickIConfirmMyOrderButton();
    assertAll(
        () -> assertTrue(orderConfirmationPage.informationBox().startsWith(startMessageText)),
        () -> assertTrue(orderConfirmationPage.informationBox().endsWith(endsMessageText))
    );
  }
}
