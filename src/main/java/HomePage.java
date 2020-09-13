import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div[class='tooltipTrigger tooltip-trigger uiTooltip'] span[class='uiImage']")
            private WebElement uiImage;
    @FindBy(css = "h1[class='profile-card-name'] a[class='profile-link-label']")
            private WebElement loggedUserName;
    @FindBy(css = "a[class='profile-link-label logout uiOutputURL']")
            private WebElement logoutButton;

    public String getLoggedUsername () {
        wait.until(ExpectedConditions.visibilityOf(uiImage));
        uiImage.click();
        wait.until(ExpectedConditions.visibilityOf(loggedUserName));
        String username = loggedUserName.getText();
        uiImage.click();
        return username;
    }

    public void logOut () {
        wait.until(ExpectedConditions.visibilityOf(uiImage));
        uiImage.click();
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
}
