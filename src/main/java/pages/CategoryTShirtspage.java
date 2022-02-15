package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class CategoryTShirtspage {

  private final SelenideElement fadedTShirt = element("[alt$='shirts']");
  private final SelenideElement moreButton = element(".lnk_view");

  public CategoryTShirtspage hoverFadedTShirt() {
    fadedTShirt.should(Condition.visible).hover();
    return this;
  }

  public FadedTShirtPage clickMoreButton() {
    moreButton.click();
    return new FadedTShirtPage();
  }
}
