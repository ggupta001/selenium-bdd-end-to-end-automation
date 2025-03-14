package org.stepcampus.stepdefinitions;

import io.cucumber.java.en.*;
import org.stepcampus.factory.WebDriverManagerUtils;
import org.stepcampus.pageobjects.LoginPage;

import java.io.IOException;

public class LoginPageTest extends WebDriverManagerUtils {
    public LoginPage loginpg;

    // Constructor to initialize the LoginPage object
    public LoginPageTest() throws IOException {
        loginpg = new LoginPage(driver);
    }

    @Given("User can see Customer login page")
    public void user_can_see_customer_login_page() {
        loginpg.seeLoginPage();
    }

    @When("user enter username and password")
    public void user_enter_username_and_password() {
        // Fetch username and password from environment variables
        final String userName = System.getenv("MY_API_KEY"); // Fetch from environment variable
        final String password = System.getenv("DB_PASSWORD"); // Fetch from environment variable

        if (userName == null || password == null) {
            throw new IllegalArgumentException("Username or password is missing from the environment variables");
        }

        // Pass the values to the login page methods
        loginpg.enterUserName(userName);
        loginpg.enterPassword(password);
    }

    @Then("user can able to logged in")
    public void user_can_able_to_logged_in() {
        loginpg.clickOnLogin();
    }
}
