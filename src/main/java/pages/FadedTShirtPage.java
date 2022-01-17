package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class FadedTShirtPage {

  private final SelenideElement reviewButton = element("#new_comment_tab_btn");
  private final SelenideElement quality5Stars = element(".star_content [title='5']");
  private final SelenideElement titleField = element("#comment_title");
  private final SelenideElement commentField = element("#content");
  private final SelenideElement sendButton = element("#submitNewMessage");
  private final SelenideElement message = element(".fancybox-inner > p");
  private final SelenideElement okButton = element(".submit > .btn-default");

  public FadedTShirtPage clickReviewButton() {
    reviewButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return this;
  }

  public FadedTShirtPage pickQuality5Stars() {
    quality5Stars.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    return this;
  }

  public FadedTShirtPage setTitleField(String title) {
    titleField.setValue(title);
    return this;
  }

  public FadedTShirtPage setCommentField(String comment) {
    commentField.setValue(comment);
    return this;
  }

  public FadedTShirtPage clickSendButton() {
    sendButton.click();
    return this;
  }

  public String getMessage() {
    return message.getText();
  }

  public FadedTShirtPage clickOkButton() {
    okButton.click();
    return this;
  }
}
