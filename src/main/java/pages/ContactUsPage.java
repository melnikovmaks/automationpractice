package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class ContactUsPage {

  private final SelenideElement contactCustomerService = element("#id_contact [value='2']");
  private final SelenideElement lastOrder = element("[name='id_order'] option:last-child");
  private final SelenideElement lastProduct = element(".product_select option:last-child");
  private final SelenideElement messageField = element("#message");
  private final SelenideElement sendButton = element("#submitMessage");
  private final SelenideElement alertMessage = element(".alert-success");

  public ContactUsPage pickContactCustomerService() {
    contactCustomerService.click();
    return new ContactUsPage();
  }

  public ContactUsPage pickLastOrder() {
    lastOrder.click();
    return new ContactUsPage();
  }

  public ContactUsPage pickLastProduct() {
    lastProduct.click();
    return new ContactUsPage();
  }

  public ContactUsPage setMessageFieldOnField(String message) {
    messageField.setValue(message);
    return this;
  }

  public ContactUsPage clickSendButton() {
    sendButton.click();
    return new ContactUsPage();
  }

  public String getAlertMessage() {
    return alertMessage.getText();
  }
}
