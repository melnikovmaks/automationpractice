package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.element;

public class LoginPage {

  private final SelenideElement emailLoginField = element("#email");
  private final SelenideElement passwdField = element("#passwd");
  private final SelenideElement emailCreateField = element("#email_create");
  private final SelenideElement submitCreateButton = element("#SubmitCreate");

  public LoginPage setMailOnField(String mail) {
    emailLoginField.shouldBe(Condition.empty).setValue(mail);
    return this;
  }

  public LoginPage setPasswdOnField(String passwd) {
    passwdField.shouldBe(Condition.empty).setValue(passwd);
    return this;
  }

  public MyAccountPage pressEnterForLogin() {
    Selenide.actions().sendKeys(Keys.ENTER).perform();
    return new MyAccountPage();
  }

  public LoginPage setValueOnCreateField(String email) {
    emailCreateField.setValue(email);
    return this;
  }

  public CreateAccountPage clickSubmitCreateButton() {
    submitCreateButton.click();
    return new CreateAccountPage();
  }
}
