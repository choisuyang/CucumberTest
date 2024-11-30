package io.cucumber.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.LoginPage;
import io.cucumber.pages.ProductPage;
import io.cucumber.pages.PurchasePage;
import io.cucumber.pages.SchedulePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.Configuration.WebDriverConfig;


public class SchedulePageSteps {
    public static WebDriver driver;
    private final WebDriverConfig webDriverConfig = new WebDriverConfig();
    private LoginPage loginPage;
    private SchedulePage schedulePage;
    private ProductPage productPage;
    private PurchasePage purchasePage;

    @Before("@Abc")
    public void setUp () {
        driver = new ChromeDriver(webDriverConfig.getChromeOptions());
        driver.get(webDriverConfig.getDriverUrl());

        loginPage = new LoginPage(driver);
        schedulePage = new SchedulePage(driver);
        productPage = new ProductPage(driver);
        purchasePage = new PurchasePage(driver);
    }

    @After("@Abc")
    public void close () {
        driver.quit();
    }

    @Given("Login setup")
    public void login_setup () throws Exception {
        setUp();
        Thread.sleep(3000);
        loginPage.loginModule();
    }

    @And("Enter the schedule page")
    public void enter_the_schedule_page () throws Exception {
        schedulePage.tvScheduleBtn();
    }

    @And("Count live schedule and enter detail page")
    public void count_live_schedule_and_enter_detail_page () throws Exception {
        schedulePage.enterTheDetailPage();
    }
    @When("Click option and click purchase button")
    public void click_option_and_click_purchase_button () throws Exception {
        productPage.clickOptionAndClickPurchaseButton();
        Thread.sleep(6000);
    }

    @Then("Enter the purchase page")
    public void enter_the_purchase_page() throws Exception {
        purchasePage.btnChangePaymentWithDeposit();
        System.out.println("end");
        close();
    }

}
