package service;

import builders.CreateAccountBuilder;
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
    return new MyAccountPage();
  }
}
