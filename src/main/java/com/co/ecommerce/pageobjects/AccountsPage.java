package com.co.ecommerce.pageobjects;

import com.co.ecommerce.utils.GenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.co.ecommerce.utils.Utils.aleatoryAccount;

public class AccountsPage extends GenericPage {

    private final WebDriver driver;
    @FindBy(id = "accountTable")
    WebElement table;


    public AccountsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getlistaCuentas() {
        return table.findElements(By.tagName("a"));

    }

    public String  obtenerCuentaAleatoria() {
        int count= getlistaCuentas().size();
        int indexAccount=aleatoryAccount(count);
        return getlistaCuentas().get(indexAccount).getText();
    }
}
