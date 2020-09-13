import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input#username")
    private WebElement usernameField;
    @FindBy(css = "input#password")
    private WebElement passwordField;
    @FindBy(css = "input#Login")
    private WebElement loginButton;

    public void loginToSalesforce(String login,String password){
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
