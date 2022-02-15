package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class MyWishlistsPage {

  private final SelenideElement myWishlistButton = element("tr td:nth-child(1) a");
  private final SelenideElement quantityField = element("#quantity_2_7");
  private final SelenideElement priorityField = element("#priority_2_7");
  private final SelenideElement deleteButton = element(".icon-remove-sign");

  public MyWishlistsPage clickMyWishlistButton() {
    myWishlistButton.click();
    return this;
  }

  public String getQuantity() {
    return quantityField.val();
  }

  public String getPriority() {
    return priorityField.getText();
  }

  public MyWishlistsPage clickDeleteButton() {
    deleteButton.click();
    return this;
  }
}
