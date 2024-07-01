package com.co.ecommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {
    private final WebDriver driver;
    @FindBy(linkText = "Open New Account")
    WebElement openingService;
    @FindBy(linkText = "Bill Pay")
    WebElement billService;
    @FindBy(linkText = "Accounts Overview")
    WebElement accountService;

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OpeningPage goToServiceOpening() {
        openingService.click();
        return new OpeningPage(driver);
    }

    public OpeningPage goToServiceTransfer() {
        return new OpeningPage(driver);
    }

    public BillPage goToServiceBillPay() {
        billService.click();
        return new BillPage(driver);
    }

    public OpeningPage goToServiceFindTransactions() {
        return null;
    }

    public AccountsPage goToServiceAccount() {
        accountService.click();
        return new AccountsPage(driver);
    }
}
