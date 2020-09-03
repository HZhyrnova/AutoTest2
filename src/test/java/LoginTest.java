import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
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
        wait = new WebDriverWait(driver, 10, 100);
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().maximize();

    }
    @AfterAll
    public void tillDown(){
       driver.quit();
    }
    @Test
    public void shouldCorrectLogin() {
        String USERNAME = "jenkins@prepackaging.com";
        String PASSWORD = "EnxooTest123";
        String USER = "Robert Augustyniak";

        driver.get("https://prepack-skilo-dev-ed.lightning.force.com/");


        driver.findElement(By.cssSelector("input#username")).sendKeys(USERNAME);
        driver.findElement(By.cssSelector("input#password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("input#Login")).click();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div[class='tooltipTrigger tooltip-trigger uiTooltip'] span[class='uiImage']"),0));
        driver.findElement(By.cssSelector("div[class='tooltipTrigger tooltip-trigger uiTooltip'] span[class='uiImage']")).click();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h1[class='profile-card-name'] a[class='profile-link-label']"),0));
        String actualUser = driver.findElement(By.cssSelector("h1[class='profile-card-name'] a[class='profile-link-label']")).getText();

        Assertions.assertEquals(USER, actualUser, "Wrong username");
        driver.findElement(By.cssSelector("a[class='profile-link-label logout uiOutputURL']")).click();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("input#username"),0));

    }
    @Test
    public void shouldDisplayErrorWhenEmptyPassword(){
        String USERNAME = "jenkins@prepackaging.com";

        driver.get("https://prepack-skilo-dev-ed.lightning.force.com/");


        driver.findElement(By.cssSelector("input#username")).sendKeys(USERNAME);
        driver.findElement(By.cssSelector("input#Login")).click();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div#error"),0));
        String errorMessage = driver.findElement(By.cssSelector("div#error")).getText();

        Assertions.assertEquals("Please enter your password.", errorMessage, "Wrong message");

    }
    @Test
    public void shouldDisplayErrorWhenIncorrectData(){
        String USERNAME = "jenkins@prepackaging.com";
        String PASSWORD = "EnxooTest1233";

        driver.get("https://prepack-skilo-dev-ed.lightning.force.com/");


        driver.findElement(By.cssSelector("input#username")).sendKeys(USERNAME);
        driver.findElement(By.cssSelector("input#password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("input#Login")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div#error")),"Please check your username and password. If you still can't log in, contact your Salesforce administrator."));
       // wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div#error"),0));

       // String errorMessage1 = driver.findElement(By.cssSelector("div#error")).getText();

       // Assertions.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.", errorMessage1, "Wrong username");
    }


}
