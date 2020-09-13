import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest {



    @Test
    public void shouldCorrectLogin() {
        String USERNAME = "jenkins@prepackaging.com";
        String PASSWORD = "EnxooTest123";
        String USER = "Robert Augustyniak";

        LoginPage LoginPage = new LoginPage(driver);
        HomePage HomePage = new HomePage(driver);

        LoginPage.loginToSalesforce(USERNAME, PASSWORD);
        String actualUser = HomePage.getLoggedUsername();

        Assertions.assertEquals(USER, actualUser, "Wrong username");

        HomePage.logOut();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("input#username"),0));

    }
    @Test
    public void shouldDisplayErrorWhenEmptyPassword(){
        String USERNAME = "jenkins@prepackaging.com";
        String PASSWORD = "";

        LoginPage LoginPage = new LoginPage(driver);

        LoginPage.loginToSalesforce(USERNAME, PASSWORD);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div#error"),0));
        String errorMessage = driver.findElement(By.cssSelector("div#error")).getText();

        Assertions.assertEquals("Please enter your password.", errorMessage, "Wrong message");

    }
    @Test
    public void shouldDisplayErrorWhenIncorrectData(){
        String USERNAME = "jenkins@prepackaging.com";
        String PASSWORD = "EnxooTest1233";

        LoginPage LoginPage = new LoginPage(driver);

        LoginPage.loginToSalesforce(USERNAME, PASSWORD);

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div#error")),"Please check your username and password. If you still can't log in, contact your Salesforce administrator."));
       // wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div#error"),0));

       // String errorMessage1 = driver.findElement(By.cssSelector("div#error")).getText();

       // Assertions.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.", errorMessage1, "Wrong username");
    }


}
