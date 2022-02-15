package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class OrderSummaryPage {

  private final SelenideElement iConfirmMyOrderButton = element("#cart_navigation .button-medium");

  public OrderConfirmationPage clickIConfirmMyOrderButton() {
    iConfirmMyOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new OrderConfirmationPage();
  }
}
