package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DashboardPage {

    private final By formsAndListsButton = By.xpath("//div[@data-testid='navigation_formsandlists']");
    private final By formsPageButton = By.xpath("//div[@data-testid='navigation_forms']");

    private final SHAFT.GUI.WebDriver driver;

    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the Forms and Lists button on the left side menu.
     *
     * @return DashboardPage instance for method chaining
     */
    public DashboardPage clickFormsAndListsButton() {
        driver.element().click(formsAndListsButton);
        return this;
    }

    /**
     * Clicks the Forms page button to navigate to the Forms page.
     *
     * @return FormsPage instance after navigation
     */
    public FormsPage clickFormsPageButton() {
        driver.element().click(formsPageButton);
        return new FormsPage(driver);
    }

}
