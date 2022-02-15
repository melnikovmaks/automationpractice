package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class ShippingPage {

  private final SelenideElement termsOfServiceCheckbox = element("#uniform-cgv");
  private final SelenideElement proceedToCheckoutButton = element(".standard-checkout");

  public ShippingPage clickTermsOfServiceCheckbox() {
    termsOfServiceCheckbox.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return this;
  }

  public PaymentPage clickProceedToCheckoutButton() {
    proceedToCheckoutButton.click();
    return new PaymentPage();
  }
}
