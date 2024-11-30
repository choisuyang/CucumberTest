package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private static WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='prd_info_wrap']/div/div/a[contains(@class,'_buy')]")
    public WebElement buyButton;

    public ProductPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void clickOptionAndClickPurchaseButton() throws Exception {
        buyButton.click();
    }

}
