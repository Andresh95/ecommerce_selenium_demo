package com.co.ecommerce.pageobjects;

import com.co.ecommerce.utils.GenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpeningPage extends GenericPage {
    private WebDriver driver;

    public OpeningPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By titleApertura = By.cssSelector("h1[class='title']");
    By type = By.id("type");
    By button = By.cssSelector("input[value='Open New Account']");
    By bloqueResult = By.id("openAccountResult");
    By newAccount = By.id("newAccountId");
    By ElementAccount = By.id("accountId");
    By ElementType = By.id("accountType");

    public void accountOpen(String valor) throws InterruptedException {
        WebElement staticDropdown = driver.findElement(type);
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(valor);
        waitForElementToDisappear();
        driver.findElement(button).click();
    }

    public String capturarRespuestaApertura() {
        waitForElementToAppear(bloqueResult);
        WebElement bloque = driver.findElement(bloqueResult);
        return bloque.findElement(titleApertura).getText();
    }


    public String extraerCuentaNueva() {
        waitForElementToAppear(bloqueResult);
        WebElement bloke = driver.findElement(bloqueResult);
        return bloke.findElement(newAccount).getText();
    }


    public void accountDetails() throws InterruptedException {
        WebElement bloke = driver.findElement(bloqueResult);
        bloke.findElement(newAccount).click();
        waitForElementToDisappear();
    }

    public Boolean validateAccount(String type, String account) {
        String validateAccount = driver.findElement(ElementAccount).getText();
        String validateType = driver.findElement(ElementType).getText();
        return validateAccount.equals(account) && validateType.equals(type);
    }
}
