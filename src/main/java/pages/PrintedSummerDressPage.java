package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class PrintedSummerDressPage {

  private final SelenideElement orangeColorPick = element("#color_13");
  private final SelenideElement blackColorPick = element("#color_11");
  private final SelenideElement blueColorPick = element("#color_14");
  private final SelenideElement yellowColorPick = element("#color_16");
  private final SelenideElement mainImage = element("#bigpic");

  public String getColorOrangeColorPick() {
    return orangeColorPick.getCssValue("background-color");
  }

  public String getColorBlackColorPick() {
    return blackColorPick.getCssValue("background-color");
  }

  public String getColorBlueColorPick() {
    return blueColorPick.getCssValue("background-color");
  }

  public String getColorYellowColorPick() {
    return yellowColorPick.getCssValue("background-color");
  }

  public PrintedSummerDressPage pickColorBlack() {
    blackColorPick.click();
    return this;
  }

  public PrintedSummerDressPage pickColorOrange() {
    orangeColorPick.click();
    return this;
  }

  public PrintedSummerDressPage pickColorBlue() {
    blueColorPick.click();
    return this;
  }

  public PrintedSummerDressPage pickColorYellow() {
    yellowColorPick.click();
    return this;
  }

  public String getSrcMainImage() {
    return mainImage.getAttribute("src");
  }
}
