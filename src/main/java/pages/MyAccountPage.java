package pages;

import java.time.Duration;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class MyAccountPage {

  private final ElementsCollection menuBlocksButtons = elements(".sf-with-ul");
  private final SelenideElement tShirtsButton = element(".sf-arrows >li:last-child");
  private final SelenideElement categoryBlousesButton = element("[title='Blouses']");
  private final SelenideElement wishlistButton = element(".lnk_wishlist");

  public CategoryDressesPage openCategoryDressesPage() {
    menuBlocksButtons.should(CollectionCondition.size(4), Duration.ofSeconds(20)).get(3).click();
    return new CategoryDressesPage();
  }

  public MyAccountPage hoverCategoryWoman() {
    menuBlocksButtons.should(CollectionCondition.size(4), Duration.ofSeconds(20)).get(0).hover();
    return new MyAccountPage();
  }

  public CategoryBlousesPage clickCategoryBlousesButton() {
    categoryBlousesButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return new CategoryBlousesPage();
  }

  public CategoryTShirtspage clickTShirtsButton() {
    tShirtsButton.click();
    return new CategoryTShirtspage();
  }

  public MyWishlistsPage clickWishlistButton() {
    wishlistButton.click();
    return new MyWishlistsPage();
  }
}
