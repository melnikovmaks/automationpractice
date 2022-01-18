package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class CreateAccountPage {

  private final SelenideElement mrRadio = element("#id_gender1");
  private final SelenideElement firstNameField = element("#customer_firstname");
  private final SelenideElement lastNameField = element("#customer_lastname");
  private final SelenideElement passwdField = element("#passwd");
  private final SelenideElement daysOfBirth = element("#days [value ='3']");
  private final SelenideElement monthsOfBirth = element("#months [value ='4']");
  private final SelenideElement yearsOfBirth = element("#years [value ='2021']");
  private final SelenideElement newsletterCheckbox = element("#newsletter");
  private final SelenideElement offersCheckbox = element("#optin");
  private final SelenideElement companyField = element("#company");
  private final SelenideElement addressField = element("#address1");
  private final SelenideElement cityField1 = element("#city");
  private final SelenideElement stateFlorida = element("#id_state [value ='9']");
  private final SelenideElement postcodeField = element("#postcode");
  private final SelenideElement usCountry = element("#id_country [value='21']");
  private final SelenideElement additionalInformationField = element("#other");
  private final SelenideElement homePhoneField = element("#phone");
  private final SelenideElement mobilePhoneField = element("#phone_mobile");
  private final SelenideElement addressAliasField = element("#alias");
  private final SelenideElement registerButton = element("#submitAccount");

  public CreateAccountPage clickMrRadio() {
    mrRadio.click();
    return this;
  }

  public CreateAccountPage setFirstNameOnField(String firstName) {
    firstNameField.setValue(firstName);
    return this;
  }

  public CreateAccountPage setLastNameField(String lastName) {
    lastNameField.setValue(lastName);
    return this;
  }

  public CreateAccountPage setPasswdOnField(String passwd) {
    passwdField.setValue(passwd);
    return this;
  }

  public CreateAccountPage pickDaysOfBirth() {
    daysOfBirth.click();
    return this;
  }

  public CreateAccountPage pickMonthsOfBirth() {
    monthsOfBirth.click();
    return this;
  }

  public CreateAccountPage pickYearsOfBirth() {
    yearsOfBirth.click();
    return this;
  }

  public CreateAccountPage clickNewsletterCheckbox() {
    newsletterCheckbox.click();
    return this;
  }

  public CreateAccountPage clickOffersCheckbox() {
    offersCheckbox.click();
    return this;
  }

  public CreateAccountPage setCompanyOnField(String company) {
    companyField.setValue(company);
    return this;
  }

  public CreateAccountPage setAddressOnField(String address) {
    addressField.setValue(address);
    return this;
  }

  public CreateAccountPage setCityOnField(String city) {
    cityField1.setValue(city);
    return this;
  }

  public CreateAccountPage pickStateFlorida() {
    stateFlorida.click();
    return this;
  }

  public CreateAccountPage setPostcodeOnField(String postcode) {
    postcodeField.setValue(postcode);
    return this;
  }

  public CreateAccountPage pickUsCountry() {
    usCountry.click();
    return this;
  }

  public CreateAccountPage setAdditionalInformationOnField(String additionalInformation) {
    additionalInformationField.setValue(additionalInformation);
    return this;
  }

  public CreateAccountPage setHomePhoneOnField(String homePhone) {
    homePhoneField.setValue(homePhone);
    return this;
  }

  public CreateAccountPage setMobilePhoneOnField(String mobilePhone) {
    mobilePhoneField.setValue(mobilePhone);
    return this;
  }

  public CreateAccountPage setAddressAliasFieldOnField(String addressAlias) {
    addressAliasField.setValue(addressAlias);
    return this;
  }

  public MyAccountPage clickRegisterButton() {
    registerButton.click();
    return new MyAccountPage();
  }
}
