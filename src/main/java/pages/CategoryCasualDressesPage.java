package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class CategoryCasualDressesPage {

  private final SelenideElement printedDress = element("[alt='Printed Dress']");
  private final SelenideElement addToCartButton = element(".ajax_add_to_cart_button span");
  private final SelenideElement checkoutButton = element(".button-medium");

  public CategoryCasualDressesPage hoverPrintedDress() {
    printedDress.should(Condition.visible).hover();
    return this;
  }

  public CategoryCasualDressesPage addToCart() {
    addToCartButton.click();
    return this;
  }

  public ShoppingCartPage redirectToShoppingCart() {
    checkoutButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new ShoppingCartPage();
  }
}
