package service;

import pages.LoginPage;
import pages.MyAccountPage;

public class AuthenticationService {

  RandomMailService randomMailService = new RandomMailService();
  LoginPage loginPage = new LoginPage();

  public MyAccountPage loginOnSite(
      String mail,
      String password
  ) {
    loginPage.setMailOnField(mail)
        .setPasswdOnField(password)
        .pressEnterForLogin();
    return new MyAccountPage();
  }

  public MyAccountPage createAccount() {
    loginPage.setValueOnCreateField(randomMailService.mailRandom())
        .clickSubmitCreateButton()
        .clickMrRadio()
        .setFirstNameOnField("Ivan")
        .setLastNameField("Ivanov")
        .setPasswdOnField("Qwerty123")
        .pickDaysOfBirth()
        .pickMonthsOfBirth()
        .pickYearsOfBirth()
        .clickNewsletterCheckbox()
        .clickOffersCheckbox()
        .setCompanyOnField("kaseya")
        .setAddressOnField("701 Brickell Avenue")
        .setCityOnField("Miami")
        .pickStateFlorida()
        .setPostcodeOnField("33131")
        .pickUsCountry()
        .setAdditionalInformationOnField("Additional information")
        .setHomePhoneOnField("+375292929297")
        .setMobilePhoneOnField("+375333333333")
        .setAddressAliasFieldOnField("18, Baker street")
        .clickRegisterButton();
    return new MyAccountPage();
  }
}
