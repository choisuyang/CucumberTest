package io.cucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CjOnstyleLogin {
    public static WebDriver driver;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "D:\\chromedriver\\chromedriver-win64_130\\chromedriver.exe"; // 드라이버 경로

    @Before
    public void setUp() throws Exception {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);


        // 온스타일 URL 진입
        driver.get("https://display.cjonstyle.com/p/homeTab/main?hmtabMenuId=H00005");
        Thread.sleep(5000);

    }
    @Test
    public void assertTitle() {

        String title = driver.getTitle();
        Assertions.assertEquals(title,"홈 | CJ온스타일");
    }


    @Given("Input text ID and PW")
    public void input_text_id_and_pw() {
        System.out.println("11");
    }

    @When("Click Login Button")
    public void click_login_button(){
        System.out.println("222");
    }

    @Then("Move home page and check text {string}")
    public void move_home_page_and_check_text(String result){
        System.out.println("33" + result);
    }


    @After
    public void close (){
        driver.quit();
    }
}
