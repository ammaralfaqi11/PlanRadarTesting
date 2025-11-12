import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    SHAFT.TestData.JSON loginCred = new SHAFT.TestData.JSON("credentials.json");

    private final String validEmail = loginCred.getTestData("validEmail");
    private final String validPassword = loginCred.getTestData("validPassword");

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");

    private final SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        driver.browser().navigateToURL("");
        return this;
    }

    public LoginPage login() {
        driver.element().type(emailInput, validEmail);
        driver.element().type(passwordInput, validPassword);
        driver.element().click(loginButton);
        return this;
    }
}
