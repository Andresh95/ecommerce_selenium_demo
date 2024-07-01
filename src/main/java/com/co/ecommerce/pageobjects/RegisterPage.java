package com.co.ecommerce.pageobjects;

import com.co.ecommerce.utils.GenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static com.co.ecommerce.utils.Utils.aleatoryUser;

public class RegisterPage extends GenericPage {
    private WebDriver driver;
    @FindBy(id = "customer.firstName")
    WebElement firstName;
    @FindBy(id = "customer.lastName")
    WebElement lastName;
    @FindBy(id = "customer.address.street")
    WebElement address;
    @FindBy(id = "customer.address.city")
    WebElement city;
    @FindBy(id = "customer.address.state")
    WebElement state;
    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;
    @FindBy(id = "customer.phoneNumber")
    WebElement phone;
    @FindBy(id = "customer.ssn")
    WebElement ssn;
    @FindBy(id = "customer.username")
    WebElement username;
    @FindBy(id = "customer.password")
    WebElement password;
    @FindBy(id = "repeatedPassword")
    WebElement confirm;
    @FindBy(css = "input[value='Register']")
    WebElement register;

    By completed= By.xpath("//*[@id=\"rightPanel\"]/h1");

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String fillOutForm(Map<String, String> formulario) {
        String user=formulario.get("Username")+aleatoryUser();
        firstName.sendKeys(formulario.get("FirstName"));
        lastName.sendKeys(formulario.get("LastName"));
        address.sendKeys(formulario.get("Address"));
        city.sendKeys(formulario.get("City"));
        state.sendKeys(formulario.get("State"));
        zipCode.sendKeys(formulario.get("ZipCode"));
        phone.sendKeys(formulario.get("Phone"));
        ssn.sendKeys(formulario.get("SSN"));
        username.sendKeys(user);
        password.sendKeys(formulario.get("Password"));
        confirm.sendKeys(formulario.get("Confirm"));
        register.click();
        return user;
    }

    public String registerCompleted() {
        return driver.findElement(completed).getText();
    }
}
