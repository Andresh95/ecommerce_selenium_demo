package com.co.ecommerce.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/registrar_cliente.feature",
        glue = "com.co.ecommerce.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegisterTest {
}
