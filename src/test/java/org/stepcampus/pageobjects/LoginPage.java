package org.stepcampus.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.stepcampus.factory.WebDriverManagerUtils;

import java.io.IOException;

public class LoginPage extends WebDriverManagerUtils {
    public LoginPage(WebDriver driver) throws IOException {
        WebDriverManagerUtils.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement customerLogin;
    @FindBy(xpath="//input[@name='username']")
    WebElement userName;
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    @FindBy(xpath="(//input[@type='submit'])[1]")
    WebElement loginButton;


    public void seeLoginPage(){
       String text= customerLogin.getText();
        Assert.assertTrue(text.contains("Customer Login"));
    }
    public void enterUserName(String uName){
        userName.sendKeys(uName);
    }
    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public void clickOnLogin(){
        loginButton.click();
    }
}
