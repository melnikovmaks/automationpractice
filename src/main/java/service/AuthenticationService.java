package service;

import builders.CreateAccountBuilder;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pages.LoginPage;
import pages.MyAccountPage;

public class AuthenticationService {

  private static final Logger LOG = Logger.getLogger(AuthenticationService.class);
  RandomMailService randomMailService = new RandomMailService();
  LoginPage loginPage = new LoginPage();

  @Step(value = "login on site")
  public MyAccountPage loginOnSite(
      String mail,
      String password
  ) {
    loginPage.setMailOnField(mail)
        .setPasswdOnField(password)
        .pressEnterForLogin();
    return new MyAccountPage();
  }

  @Step(value = "create account")
  public MyAccountPage createAccount(
      CreateAccountBuilder createAccountBuilder
  ) {
    loginPage.setValueOnCreateField(randomMailService.mailRandom())
        .clickSubmitCreateButton()
        .clickMrRadio()
        .setFirstNameOnField(createAccountBuilder.getFirstName())
        .setLastNameField(createAccountBuilder.getLastName())
        .setPasswdOnField(createAccountBuilder.getPasswd())
        .pickDaysOfBirth()
        .pickMonthsOfBirth()
        .pickYearsOfBirth()
        .clickNewsletterCheckbox()
        .clickOffersCheckbox()
        .setCompanyOnField(createAccountBuilder.getCompany())
        .setAddressOnField(createAccountBuilder.getAddress())
        .setCityOnField(createAccountBuilder.getCity())
        .pickStateFlorida()
        .setPostcodeOnField(createAccountBuilder.getPostcode())
        .pickUsCountry()
        .setAdditionalInformationOnField(createAccountBuilder.getAdditionalInformation())
        .setHomePhoneOnField(createAccountBuilder.getHomePhone())
        .setMobilePhoneOnField(createAccountBuilder.getMobilePhone())
        .setAddressAliasFieldOnField(createAccountBuilder.getAddressAlias())
        .clickRegisterButton();
    LOG.info("The account has been created.");
    return new MyAccountPage();
  }
}
