package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class BlouseClothesPage {

  private final SelenideElement wishlistButton = element("#wishlist_button");
  private final SelenideElement message = element(".fancybox-error");
  private final SelenideElement closeMessageButton = element(".fancybox-item");
  private final SelenideElement headerUserInfo = element(".account");

  public BlouseClothesPage clickWishlistButton() {
    wishlistButton.should(Condition.visible).click();
    return this;
  }

  public String getMessage() {
    return message.getText();
  }

  public BlouseClothesPage clickCloseMessageButton() {
    closeMessageButton.click();
    return this;
  }

  public String getAccountName() {
    return headerUserInfo.getText();
  }

  public MyAccountPage clickAccountName() {
    headerUserInfo.click();
    return new MyAccountPage();
  }
}
