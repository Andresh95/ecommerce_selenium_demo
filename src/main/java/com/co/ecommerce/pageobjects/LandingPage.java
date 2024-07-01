package com.co.ecommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;
    @FindBy(css = "input[name='username']")
    WebElement username;
    @FindBy(css = "input[name='password']")
    WebElement userPassword;
    @FindBy(css = "input[type='submit']")
    WebElement submit;
    @FindBy(linkText = "Register")
    WebElement register;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ServicesPage loginApplication(String user, String password) {
        username.sendKeys(user);
        userPassword.sendKeys(password);
        submit.click();
        return new ServicesPage(driver);
    }

    public RegisterPage register(){
        register.click();
        return new RegisterPage(driver);
    }


    public void goTo() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
}
