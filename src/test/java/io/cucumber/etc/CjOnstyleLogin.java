//package io.cucumber.etc;
//
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//d
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CjOnstyleLogin {
//    public static WebDriver driver;
////    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
////    public static final String WEB_DRIVER_PATH = "D:\\chromedriver\\chromedriver-win64_130\\chromedriver.exe"; // 드라이버 경로
////    public static final String WEB_DRIVER_PATH = "/Users/choesuyang/Documents/chromedriver-mac-x64/chromedriver";
//    @Before
//    public void setUp() throws Exception {
////        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
//        // ChromeOption 설정 영역
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("disable-gpu");
//        driver = new ChromeDriver(options);
//
//        // config 파일 설정 값 설정 (id,pw,homeurl)
//        ConfigManager config = ConfigManager.getInstance();
//        String url = config.getProperty("homeurl");
//
//
//        // 온스타일 URL 진입
//        driver.get(url);
//        //https://display.cjonstyle.com/p/homeTab/main?hmtabMenuId=H00005
//        Thread.sleep(5000);
//
//        // id,pw 변수 설정
//        String id = config.getProperty("id");
//        String pw = config.getProperty("pw");
//
//        // 로그인 버튼 클릭
//        WebElement loginBtn = driver.findElement(By.className("_loginBtn"));
//        loginBtn.click();
//        Thread.sleep(3000);
//
//        // 아이디 입력
//        WebElement inputId = driver.findElement(By.id("id_input"));
//        inputId.sendKeys(id);
//
//        // 비밀번호 입력
//        WebElement inputPw = driver.findElement(By.id("password_input"));
//        inputPw.sendKeys(pw);
//    }
//
//    @AfterEach
//    public void close (){
//        System.out.println("end");
//        driver.quit();
//    }
//
//
//
//    public void clickLoginButton() throws Exception{
//        // 로그인 버튼 클릭
//        WebElement clickLoginBtn = driver.findElement(By.id("loginSubmit"));
//        clickLoginBtn.click();
//        Thread.sleep(5000);
//    }
//
//
//    @Given("Input text ID and PW")
//    public void input_text_id_and_pw() throws Exception {
//        setUp();
//    }
//
//    @When("Click Login Button")
//    public void click_login_button() throws Exception {
//        clickLoginButton();
//    }
//
//    @Then("Move home page and check text {string}")
//    public void move_home_page_and_check_text(String text) throws Exception {
//        WebElement getText = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div[3]/ul/li[1]/a"));
//
//        String logoutText = CheckLogoutText.logoutText(getText.getText());
//        assertEquals(text,logoutText);
//        Thread.sleep(3000);
//        close();
//    }
//
//}
//
//class CheckLogoutText {
//    static String logoutText(String text) {
//        if (text != null && text.trim().equals("로그아웃")) {
//            return "logout";
//        } else {
//            return "login";
//        }
//    }
//}