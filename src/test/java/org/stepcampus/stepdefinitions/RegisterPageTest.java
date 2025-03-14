package org.stepcampus.stepdefinitions;

import io.cucumber.java.en.*;
import org.stepcampus.factory.WebDriverManagerUtils;
import org.stepcampus.pageobjects.RegisterPage;

import java.io.IOException;
import java.time.Duration;

public class RegisterPageTest extends WebDriverManagerUtils {
    public RegisterPage rpage;

    public RegisterPageTest() throws IOException {
        WebDriverManagerUtils.initilization();
        rpage=new RegisterPage(driver);
    }
    String firstName=configProperties.getProperty("first-Name");
    String LastName=configProperties.getProperty("Last-Name");
    String add=configProperties.getProperty("add");
    String cityName=configProperties.getProperty("city-Name");
    String stateName=configProperties.getProperty("state-Name");
    String zip=configProperties.getProperty("zip");
    String phone=configProperties.getProperty("phone");
    String SSN=configProperties.getProperty("SSN");
    String uName=configProperties.getProperty("uName");
    String pass=configProperties.getProperty("pass");
    String cPass=configProperties.getProperty("cPass");

    @Given("User is on Registration page")
    public void user_is_on_registration_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url=configProperties.getProperty("url");
        driver.get(url);
        rpage.clickOnRegisterButton();
    }
    @When("User filled all the details")
    public void user_filled_all_the_details() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        rpage.fillDetails(firstName,LastName,add,cityName,
                stateName,zip,phone,SSN,uName,pass,cPass);
    }
    @When("click on register")
    public void click_on_register() {
        rpage.clickOnSubmit();
    }
    @Then("User landed on Dashboard Page")
    public void user_landed_on_dashboard_page() {
    rpage.checkDasboard();
    }

}
