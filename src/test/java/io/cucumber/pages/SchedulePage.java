package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SchedulePage {
    private static WebDriver driver;
    private final WebDriverWait wait;
    private Actions actions;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[1]/div[5]/div/ul/li[1]/a")
    public WebElement tvScheduleBtn;
    @FindBy(xpath = "//ul[@class='list_schedule_prod']/li/a[1][contains(@spcid,\"HOME____live__majitem\")]")
    public List<WebElement> mainItem;
    @FindBy(xpath = "//strong[@class='tit_prod']/a/span")
    public List<WebElement> mainItemTitle;


    public SchedulePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void tvScheduleBtn() throws Exception {
        tvScheduleBtn.click();
        Thread.sleep(3000);
    }

    public void enterTheDetailPage() throws Exception {
        System.out.println(mainItem.size());
        for(WebElement titleName : mainItemTitle) {
            System.out.println("Title : " + titleName.getText());
        }
        actions = new Actions(driver);
        actions.moveToElement(mainItem.get(0)).perform();
        Thread.sleep(3000);
        actions.click(mainItem.get(0)).perform();
        Thread.sleep(3000);
    }

}
