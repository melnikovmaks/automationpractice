package pages;

import java.time.Duration;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.elements;

public class CategorySummerDressesPage {

  private final ElementsCollection printedDress = elements("[alt^='Printed Summer']");
  private final ElementsCollection moreButtons = elements(".lnk_view");

  public CategorySummerDressesPage hoverFirstPrintedDress() {
    printedDress.should(CollectionCondition.size(2), Duration.ofSeconds(20)).get(0).hover();
    return this;
  }

  public PrintedSummerDressPage clickMoreButton() {
    moreButtons.should(CollectionCondition.size(3), Duration.ofSeconds(20)).get(0).click();
    return new PrintedSummerDressPage();
  }
}
