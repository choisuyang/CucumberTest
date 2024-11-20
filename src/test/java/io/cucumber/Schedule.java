package io.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Schedule {
    public static WebDriver driver;
    // config 파일 설정 값 설정 (id,pw,homeurl)
    ConfigManager config = ConfigManager.getInstance();
    String url = config.getProperty("homeurl");
    private Actions actions;


    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);

        // 온스타일 URL 진입
        driver.get(url);
        //https://display.cjonstyle.com/p/homeTab/main?hmtabMenuId=H00005
        Thread.sleep(5000);

    }


    @After
    public void close () {
        System.out.println("end");
        driver.quit();
    }


    @Given("Login Setup")
    public void login_setup()throws Exception {
        setUp();
//        loginModule();
//        clickLoginButton();

    }

    @When("Schedule Enter Page")
    public void schedule_enter_page() throws Exception {
        clickScheduleButton();
    }

    @Then("Count Live Schedule and Enter Detail Page")
    public void count_live_schedule_and_enter_detil_page() throws Exception {
        countSchedule();
    }

    public void countSchedule() throws Exception {
        String schedule_itme = "//ul[@class=\"list_schedule_prod\"]/li/a[1][contains(@spcid, 'HOME____live__majitem')]";
        List<WebElement> item = driver.findElements(By.xpath(schedule_itme));
        System.out.println("--- > " + item.size());

        String list_name = "//strong[@class=\"tit_prod\"]/a/span";
        List<WebElement> list_title = driver.findElements(By.xpath(list_name));
        for(WebElement title : list_title) {
            System.out.println("제목 : " + title.getText());
        }

        actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(item.get(0)).perform();
        Thread.sleep(3000);

        actions.click(item.get(0)).perform();

        close();
    }

    public void loginModule() throws Exception {
        // id,pw 변수 설정
        String id = config.getProperty("id");
        String pw = config.getProperty("pw");

        // 로그인 버튼 클릭
        WebElement loginBtn = driver.findElement(By.className("_loginBtn"));
        loginBtn.click();
        Thread.sleep(3000);

        // 아이디 입력
        WebElement inputId = driver.findElement(By.id("id_input"));
        inputId.sendKeys(id);

        // 비밀번호 입력
        WebElement inputPw = driver.findElement(By.id("password_input"));
        inputPw.sendKeys(pw);
    }

    public void clickLoginButton() throws Exception{
        // 로그인 버튼 클릭
        WebElement clickLoginBtn = driver.findElement(By.id("loginSubmit"));
        clickLoginBtn.click();
        Thread.sleep(5000);
    }

    public void clickScheduleButton() throws Exception{
        WebElement clickScheduleBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div[5]/div/ul/li[1]/a"));
        clickScheduleBtn.click();
        System.out.println("clickScheduleBtn");
    }


}


