import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DashboardPage {

    private final By formsAndListsButton = By.xpath("//div[@data-testid='navigation_formsandlists']");
    private final By formsPageButton = By.xpath("//div[@data-testid='navigation_forms']");

    private final SHAFT.GUI.WebDriver driver;

    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public DashboardPage clickFormsAndListsButton() {
        driver.element().click(formsAndListsButton);
        return this;
    }

    public void clickFormsPageButton() {
        driver.element().click(formsPageButton);
    }

}
