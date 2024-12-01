package io.cucumber.pages;
import io.cucumber.Configuration.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final WebDriverConfig webDriverConfig = new WebDriverConfig();
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "srh_keyword")
    public WebElement searchInput;
    @FindBy(className = "_search")
    public WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"cont_listing0\"]/div[7]/ul/li[1]/a")
    public WebElement clickFirstItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void searchInput() throws Exception {
        Thread.sleep(3000);
        searchInput.sendKeys("2035051761");
        searchButton.click();
        Thread.sleep(3000);
    }

    public void clickFirstItem() throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(clickFirstItem)).click();
        Thread.sleep(3000);
    }
}
