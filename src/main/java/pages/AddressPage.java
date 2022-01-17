package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class AddressPage {

  private final SelenideElement proceedToCheckoutButton = element(".cart_navigation .button");

  public ShippingPage clickProceedToCheckoutButton() {
    proceedToCheckoutButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new ShippingPage();
  }
}
