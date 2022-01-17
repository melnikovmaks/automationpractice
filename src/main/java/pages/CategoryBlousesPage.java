package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class CategoryBlousesPage {

  private final SelenideElement blouseClothes = element("[alt='Blouse']");
  private final SelenideElement moreButton = element(".lnk_view");

  public CategoryBlousesPage hoverFadedTShirt() {
    blouseClothes.should(Condition.visible).hover();
    return this;
  }

  public BlouseClothesPage clickMoreButton() {
    moreButton.click();
    return new BlouseClothesPage();
  }
}
