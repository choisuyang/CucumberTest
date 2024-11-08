package io.cucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckLogoutText {
    static String logoutText(String text) {
        if (text != null && text.trim().equals("로그아웃")) {
            return "logout";
        } else {
            return "login";
        }
    }
}

public class CjOnstyleLogin {
    public static WebDriver driver;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "D:\\chromedriver\\chromedriver-win64_130\\chromedriver.exe"; // 드라이버 경로
//    public static final String WEB_DRIVER_PATH = "/Users/choesuyang/Documents/chromedriver-mac-x64/chromedriver";

    public void setUp() throws Exception {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);

        // 온스타일 URL 진입
        driver.get("https://display.cjonstyle.com/p/homeTab/main?hmtabMenuId=H00005");
        Thread.sleep(5000);

        WebElement loginBtn = driver.findElement(By.className("_loginBtn"));
        loginBtn.click();
        Thread.sleep(3000);

        // 아이디 입력
        WebElement inputId = driver.findElement(By.id("id_input"));
        inputId.sendKeys("chltndid724");

        // 비밀번호 입력
        WebElement inputPw = driver.findElement(By.id("password_input"));
        inputPw.sendKeys("cjmall2$$");
    }

    public void clickLoginButton() throws Exception{
        // 로그인 버튼 클릭
        WebElement clickLoginBtn = driver.findElement(By.id("loginSubmit"));
        clickLoginBtn.click();
        Thread.sleep(5000);
    }


    @Given("Input text ID and PW")
    public void input_text_id_and_pw() throws Exception {
        setUp();
    }

    @When("Click Login Button")
    public void click_login_button() throws Exception {
        clickLoginButton();
    }

    @Then("Move home page and check text {string}")
    public void move_home_page_and_check_text(String text) throws Exception {
        WebElement getText = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div[3]/ul/li[1]/a"));

        String logoutText = CheckLogoutText.logoutText(getText.getText());
        assertEquals(text,logoutText);
        Thread.sleep(3000);
    }

    @After
    public void close (){
        driver.quit();
    }
}
