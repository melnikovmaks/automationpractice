package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.elements;

public class CategoryDressesPage {

  private final ElementsCollection dressesCategoryImg = elements(".img");

  public CategoryCasualDressesPage openCategoryCasualDressesPage() {
    dressesCategoryImg.should(CollectionCondition.size(3)).get(0).click();
    return new CategoryCasualDressesPage();
  }
}
