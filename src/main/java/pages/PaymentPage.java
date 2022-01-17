package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class PaymentPage {

  private final SelenideElement payByBankWireButton = element(".bankwire");

  public OrderSummaryPage clickPayByBankWireButton() {
    payByBankWireButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new OrderSummaryPage();
  }
}
