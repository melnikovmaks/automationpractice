package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class ShoppingCartPage {

  private final SelenideElement proceedToCheckoutButton = element(".standard-checkout");

  public AddressPage clickProceedToCheckoutButton() {
    proceedToCheckoutButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new AddressPage();
  }
}
