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
    @FindBy(xpath = "//div[@class=\"prd_content_wrap\"]/div[contains(@class,'option_wrap')]/div/div/div/a")
    public WebElement firstOption;
    @FindBy(xpath = "//ul[@class='option_list']/li[3]/a")
    public WebElement firstOptionItem;
    @FindBy(xpath = "//ul[@class='option_list']/li/a")
    public WebElement secondOptionItem;

    public ProductPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void clickOptionAndClickPurchaseButton() throws Exception {
        buyButton.click();
        Thread.sleep(3000);
    }

    public void clickFirstOption() throws Exception {
        firstOption.click();
        Thread.sleep(3000);
        if (firstOptionItem.getText().contains("매진")){
            secondOptionItem.click();
        } else {
            firstOptionItem.click();
        }
        Thread.sleep(3000);
    }

}
