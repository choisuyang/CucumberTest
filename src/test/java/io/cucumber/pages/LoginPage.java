package io.cucumber.pages;

import io.cucumber.Configuration.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static final WebDriverConfig webDriverConfig = new WebDriverConfig();
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div[1]/div[3]/ul/li[1]/a")
    private WebElement loginBtn;
    @FindBy (id = "password_input")
    private WebElement inputPw;
    @FindBy (id = "loginSubmit")
    private WebElement clickLoginBtn;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void loginModule() throws Exception {

        String userId = webDriverConfig.getProperties("userid");
        String password  = webDriverConfig.getProperties("password");

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        Thread.sleep(3000);

        driver.findElement(By.id("id_input")).sendKeys(userId);
        inputPw.sendKeys(password);
        clickLoginBtn.click();
        Thread.sleep(3000);
    }
}
