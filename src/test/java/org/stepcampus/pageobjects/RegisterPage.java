package org.stepcampus.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.stepcampus.factory.WebDriverManagerUtils;

import java.io.IOException;

public class RegisterPage extends WebDriverManagerUtils {
    public RegisterPage(WebDriver driver) throws IOException {
        WebDriverManagerUtils.driver=driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath="//a[text()='Register']")
    WebElement registerButton;

    @FindBy(id="customer.firstName")
    WebElement fName;
    @FindBy(id="customer.lastName")
    WebElement lName;
    @FindBy(id="customer.address.street")
    WebElement address;
    @FindBy(id="customer.address.city")
    WebElement city;
    @FindBy(id="customer.address.state")
    WebElement state;
    @FindBy(id="customer.address.zipCode")
    WebElement zipcode;
    @FindBy(id="customer.phoneNumber")
    WebElement phoneNumber;
    @FindBy(id="customer.ssn")
    WebElement ssnNumber;
    @FindBy(id="customer.username")
    WebElement userName;
    @FindBy(id="customer.password")
    WebElement password;
    @FindBy(id="repeatedPassword")
    WebElement confirmPassword;
    @FindBy(xpath="(//input[@type='submit'])[2]")
    WebElement submit;
    @FindBy(xpath="//h1[@class='title']")
    WebElement dashboardText;

public void clickOnRegisterButton(){
    registerButton.click();
}
public void fillDetails(String firstName, String LastName, String add,
                        String cityName, String stateName, String zip,
                        String phone,String SSN, String uName, String pass, String cPass){
    fName.sendKeys(firstName);
    lName.sendKeys(LastName);
    address.sendKeys(add);
    city.sendKeys(cityName);
    state.sendKeys(stateName);
    zipcode.sendKeys(zip);
    phoneNumber.sendKeys(phone);
    ssnNumber.sendKeys(SSN);
    userName.sendKeys(uName);
    password.sendKeys(pass);
    confirmPassword.sendKeys(cPass);
}
public void clickOnSubmit(){
    submit.click();
    }
    public void checkDasboard(){
        String successMessage = dashboardText.getText();
        Assert.assertTrue(successMessage.contains("Welcome"));

    }
}
