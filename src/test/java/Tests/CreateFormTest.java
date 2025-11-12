package Tests;

import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateFormTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test
    public void createFormTest() {
        new LoginPage(driver)
                .navigateToLoginPage()
                .login()
                .clickFormsAndListsButton()
                .clickFormsPageButton();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}