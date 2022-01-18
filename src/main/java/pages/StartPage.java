package pages;

import java.time.Duration;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class StartPage {

  private final SelenideElement signInButton = element(".login");
  private final ElementsCollection menuBlocksButtons = elements(".sf-with-ul");
  private final SelenideElement summerDressesCategory = element(".submenu-container > li:last-child a");

  public LoginPage openLoginPage() {
    signInButton.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
    return new LoginPage();
  }

  public StartPage hoverCategoryDresses() {
    menuBlocksButtons.should(CollectionCondition.size(4), Duration.ofSeconds(20)).get(3).hover();
    return this;
  }

  public CategorySummerDressesPage clickSummerDressesCategory() {
    summerDressesCategory.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new CategorySummerDressesPage();
  }
}
