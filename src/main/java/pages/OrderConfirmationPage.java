package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class OrderConfirmationPage {

  private final SelenideElement informationBox = element(".box");
  private final SelenideElement contactUsButton = element("#contact-link");

  public String informationBox() {
    return informationBox.getText();
  }

  public ContactUsPage clickContactUsButton() {
    contactUsButton.click();
    return new ContactUsPage();
  }
}
