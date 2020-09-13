import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30, 100);
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().maximize();
        driver.get("https://prepack-skilo-dev-ed.lightning.force.com/");

    }
    @AfterAll
    public void tillDown(){
        driver.quit();
    }
}
