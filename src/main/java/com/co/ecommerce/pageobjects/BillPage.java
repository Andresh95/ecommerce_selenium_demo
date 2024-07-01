package com.co.ecommerce.pageobjects;

import com.co.ecommerce.utils.GenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.Map;

public class BillPage extends GenericPage {
    private WebDriver driver;
    By success = By.cssSelector("#billpayResult > h1");
    @FindBy(name = "payee.name")
    WebElement name;
    @FindBy(name = "payee.address.street")
    WebElement address;
    @FindBy(name = "payee.address.city")
    WebElement city;
    @FindBy(name = "payee.address.state")
    WebElement state;
    @FindBy(name = "payee.address.zipCode")
    WebElement zipCode;
    @FindBy(name = "payee.phoneNumber")
    WebElement phone;
    @FindBy(name = "payee.accountNumber")
    WebElement accountDestino;
    @FindBy(name = "verifyAccount")
    WebElement verifyAccount;
    @FindBy(name = "amount")
    WebElement amount;
    @FindBy(name = "fromAccountId")
    WebElement listAccount;
    @FindBy(css = "input[type='button']")
    WebElement sendPay;

    public BillPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void executeTransaction(Map<String, String> datosPago, String cuenta) throws InterruptedException {
        name.sendKeys(datosPago.get("PayeeName"));
        address.sendKeys(datosPago.get("Address"));
        city.sendKeys(datosPago.get("City"));
        state.sendKeys(datosPago.get("State"));
        zipCode.sendKeys(datosPago.get("ZipCode"));
        phone.sendKeys(datosPago.get("Phone"));
        accountDestino.sendKeys(datosPago.get("Account"));
        verifyAccount.sendKeys(datosPago.get("VerifyAccount"));
        amount.sendKeys(datosPago.get("Amount"));
        selectAccount(cuenta);
        sendPay.click();

    }

    public void selectAccount(String cuenta) throws InterruptedException {
        Select dropdown = new Select(listAccount);
        dropdown.selectByVisibleText(cuenta);
        waitForElementToDisappear();
    }

    public String messageSuccess() throws InterruptedException {
        waitForElementToDisappear();
        return driver.findElement(success).getText();
    }
}
