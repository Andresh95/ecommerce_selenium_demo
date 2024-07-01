package com.co.ecommerce.stepdefinitions;

import com.co.ecommerce.BaseTest;
import com.co.ecommerce.pageobjects.*;
import com.co.ecommerce.reports.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.co.ecommerce.utils.Constants.*;

public class BankStepDefinition extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BankStepDefinition.class);
    private ServicesPage servicesPage;
    private OpeningPage openingPage;
    private BillPage billPage;
    private AccountsPage accountsPage;
    private RegisterPage registerPage;
    private String cuenta;
    private static String username;

    @Before
    public void setUp(Scenario scenario) {
        ExtentReportUtil.initializeExtentReport();
        ExtentReportUtil.createTest(scenario.getName());
    }
    @Given("I want to enter the ecommerce page")
    public void iWantToEnterTheEcommercePage() throws IOException {
        launchApplication();
        servicesPage = landingPage.loginApplication(username, PASSWORD);
    }

    @Given("the user use the service {string}")
    public void theUserUseTheService(String service) {
        switch (service) {
            case "Open Account" -> openingPage = servicesPage.goToServiceOpening();
            case "Transfer Funds" -> openingPage = servicesPage.goToServiceTransfer();
            case "Bill Pay" -> billPage = servicesPage.goToServiceBillPay();
            case "Find Transactions" -> openingPage = servicesPage.goToServiceFindTransactions();
            default -> throw new IllegalStateException(SERVICE_NOT_FOUND + service);
        }
    }

    @When("you fill out the creation request {string}")
    public void youFillOutTheCreationRequest(String tyCta) throws InterruptedException {
        openingPage.accountOpen(tyCta);
    }

    @Then("the accounts answer is {string}")
    public void theAccountsAnswerIs(String answer) {
        String titleValidate = openingPage.capturarRespuestaApertura();
        try {
            Assert.assertEquals(titleValidate, answer);
            logger.info(ACCOUNT_ANSWER);
        } catch (AssertionError e) {
            logger.error(ACCOUNT_FAILED,e.getMessage());
        }
    }

    @Then("validate number and {string}")
    public void validateNumberAnd(String type) throws InterruptedException {
        String account = openingPage.extraerCuentaNueva();
        openingPage.accountDetails();
        Boolean match = openingPage.validateAccount(type, account);
        try {
            Assert.assertTrue(match);
            logger.info(OPEN_SUCCESS);
        } catch (AssertionError e) {
            logger.error(OPEN_FAILED, e.getMessage());
        }
    }

    @When("i make a payment")
    public void iMakeAPayment(List<Map<String, String>> datosPago) throws InterruptedException {
        billPage.executeTransaction(datosPago.get(0), cuenta);
    }

    @Then("validate success transaction {string}")
    public void validateSuccessTransaction(String success) throws InterruptedException {
        String message = billPage.messageSuccess();
        try {
            Assert.assertEquals(success, message);
            logger.info(PAY_SUCCESS);
        } catch (AssertionError e) {
            logger.error(PAY_FAILED, e.getMessage());
        }
    }

    @Given("i get the account and the account balance")
    public void iGetTheAccountAndTheAccountBalance() {
        accountsPage = servicesPage.goToServiceAccount();
        cuenta = accountsPage.obtenerCuentaAleatoria();
    }

    @When("i fill out the form")
    public void iFillOutTheForm(List<Map<String, String>> formulario) throws IOException {
        launchApplication();
        registerPage = landingPage.register();
        username = registerPage.fillOutForm(formulario.get(0));
    }

    @Then("the client is created")
    public void theClientIsCreated() {
        String userCapture = registerPage.registerCompleted();
        String register = "Welcome " + username;
        try {
            Assert.assertEquals(register, userCapture);
            logger.info(REGISTER_SUCCESS);
        } catch (AssertionError e) {
            logger.error(REGISTER_FAILED, e.getMessage());
        }
    }

    @After(order = 1000)
    public void tearDown() {
        super.tearDown();
        ExtentReportUtil.flushReport();
    }
}
