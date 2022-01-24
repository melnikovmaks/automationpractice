
package data.model;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TestConfigPojo {

  @SerializedName("base")
  private String mBase;
  @SerializedName("fake_base")
  private String mFakeBase;
  @SerializedName("options_arguments")
  private String mOptionsArguments;
  @SerializedName("selenium_browser")
  private String mSeleniumBrowser;
  @SerializedName("selenium_browser_size")
  private String mSeleniumBrowserSize;
  @SerializedName("selenium_headless")
  private String mSeleniumHeadless;
  @SerializedName("selenium_remote_url")
  private String mSeleniumRemoteUrl;
  @SerializedName("selenium_screenshots")
  private String mSeleniumScreenshots;
  @SerializedName("selenium_timeout")
  private String mSeleniumTimeout;
  @SerializedName("selenium_vnc")
  private String mSeleniumVnc;

  public String getBase() {
    return mBase;
  }

  public void setBase(String base) {
    mBase = base;
  }

  public String getFakeBase() {
    return mFakeBase;
  }

  public void setFakeBase(String fakeBase) {
    mFakeBase = fakeBase;
  }

  public String getOptionsArguments() {
    return mOptionsArguments;
  }

  public void setOptionsArguments(String optionsArguments) {
    mOptionsArguments = optionsArguments;
  }

  public String getSeleniumBrowser() {
    return mSeleniumBrowser;
  }

  public void setSeleniumBrowser(String seleniumBrowser) {
    mSeleniumBrowser = seleniumBrowser;
  }

  public String getSeleniumBrowserSize() {
    return mSeleniumBrowserSize;
  }

  public void setSeleniumBrowserSize(String seleniumBrowserSize) {
    mSeleniumBrowserSize = seleniumBrowserSize;
  }

  public String getSeleniumHeadless() {
    return mSeleniumHeadless;
  }

  public void setSeleniumHeadless(String seleniumHeadless) {
    mSeleniumHeadless = seleniumHeadless;
  }

  public String getSeleniumRemoteUrl() {
    return mSeleniumRemoteUrl;
  }

  public void setSeleniumRemoteUrl(String seleniumRemoteUrl) {
    mSeleniumRemoteUrl = seleniumRemoteUrl;
  }

  public String getSeleniumScreenshots() {
    return mSeleniumScreenshots;
  }

  public void setSeleniumScreenshots(String seleniumScreenshots) {
    mSeleniumScreenshots = seleniumScreenshots;
  }

  public String getSeleniumTimeout() {
    return mSeleniumTimeout;
  }

  public void setSeleniumTimeout(String seleniumTimeout) {
    mSeleniumTimeout = seleniumTimeout;
  }

  public String getSeleniumVnc() {
    return mSeleniumVnc;
  }

  public void setSeleniumVnc(String seleniumVnc) {
    mSeleniumVnc = seleniumVnc;
  }

}
