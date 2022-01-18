package enums;

public enum ColorType {
  ORANGE("rgba(243, 156, 17, 1)", "http://automationpractice.com/img/p/1/4/14-large_default.jpg"),
  BLUE("rgba(93, 156, 236, 1)", "http://automationpractice.com/img/p/1/3/13-large_default.jpg"),
  BLACK("rgba(67, 74, 84, 1)", "http://automationpractice.com/img/p/1/5/15-large_default.jpg"),
  YELLOW("rgba(241, 196, 15, 1)", "http://automationpractice.com/img/p/1/2/12-large_default.jpg");

  private final String value;
  private final String src;

  ColorType(
      String value,
      String src
  ) {
    this.value = value;
    this.src = src;
  }

  public String getRba() {
    return value;
  }

  public String getSrc() {
    return src;
  }
}
