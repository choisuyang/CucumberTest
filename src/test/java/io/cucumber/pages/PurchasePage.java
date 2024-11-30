package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasePage {

    private static WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id="_btn_change_payment")
    public WebElement btn_change_payment;
    @FindBy(xpath = "//ul[@id=\"_method_lst\"]/li[contains(@class,'nobankobook')]/div")
    public WebElement deposit;

    public PurchasePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void btnChangePaymentWithDeposit() throws Exception{
        btn_change_payment.click();
        Thread.sleep(3000);
        deposit.click();
        Thread.sleep(3000);
    }
}
