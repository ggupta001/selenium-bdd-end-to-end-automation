package org.stepcampus.stepdefinitions;

import io.cucumber.java.en.*;
import org.stepcampus.factory.WebDriverManagerUtils;
import org.stepcampus.pageobjects.LoginPage;

import java.io.IOException;

public class LoginPageTest extends WebDriverManagerUtils {
   public LoginPage loginpg;

    public LoginPageTest() throws IOException {
    loginpg=new LoginPage(driver);

    }
    @Given("User can see Customer login page")
    public void user_can_see_customer_login_page() {
        loginpg.seeLoginPage();
    }
    @When("user enter username and password")
    public void user_enter_username_and_password() {
        final String userName="MY_API_KEY";
        final String password="DB_PASSWORD";
         loginpg.enterUserName(System.getenv(userName));
         loginpg.enterPassword(System.getenv(password));
    }
    @Then("user can able to logged in")
    public void user_can_able_to_logged_in() {
        loginpg.clickOnLogin();
    }


}
