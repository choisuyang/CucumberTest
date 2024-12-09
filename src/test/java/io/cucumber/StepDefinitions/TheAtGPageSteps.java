package io.cucumber.StepDefinitions;

import io.cucumber.Configuration.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.HomePage;
import io.cucumber.pages.LoginPage;
import io.cucumber.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheAtGPageSteps {
    private static WebDriver driver;
    private final WebDriverConfig webDriverConfig = new WebDriverConfig();
    private LoginPage loginPage;
    private ProductPage productPage;
    private HomePage homePage;

    @Before("@purchase")
    public void setup () {
        driver = new ChromeDriver(webDriverConfig.getChromeOptions());
        driver.get(webDriverConfig.getDriverUrl());

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

    }
    @After("@purchase")
    public void end() {
        driver.close();
    }

    @Given("Login setting")
    public void login_setting() throws Exception {
        loginPage.loginModule();
    }

    @When("Input item {string} in search module")
    public void input_item_number_in_search_module(String code) throws Exception{
        homePage.searchInput(code);
    }

    @And("Click first item and enter the detail page")
    public void click_first_item_and_enter_the_detail_page() throws Exception{
        homePage.clickFirstItem();
    }
    @And("Click first options and click purchase button")
    public void click_first_options_and_click_purchase_button() throws Exception {
        productPage.clickFirstOption();
    }
    @Then("Success enter the purchase page")
    public void success_enter_the_purchase_page() throws Exception {
        productPage.clickOptionAndClickPurchaseButton();
    }



}
