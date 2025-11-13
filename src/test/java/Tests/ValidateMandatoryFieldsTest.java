package Tests;

import Pages.FormsPage;
import Pages.LoginPage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateMandatoryFieldsTest {
    SHAFT.GUI.WebDriver driver;
    private static final String formName = "Test Form name " + System.currentTimeMillis();

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test
    public void createNewForm() {
        new LoginPage(driver)
                .navigateToLoginPage()
                .login()
                .clickFormsAndListsButton()
                .clickFormsPageButton()
                .clickCreateFormButton()
                .typeFormName(formName)
                .clickShortTextField()
                .typeShortTextFieldNameAndDescription()
                .makeShortTextFieldMandatory()
                .clickSaveFormButton()
                .clickCloseFormButton();

        driver.verifyThat().element(new FormsPage(driver).getFormNameLocator(formName)).isVisible();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}