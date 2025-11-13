package Tests;

import Pages.FormsPage;
import Pages.LoginPage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateDefaultValueAppearanceTest {
    SHAFT.GUI.WebDriver driver;
    private static final String formName = "Test Form name " + System.currentTimeMillis();
    String defaultShortTextValue = "Test Default Text";

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test
    public void createNewFormWithDefaultValue() {
        new LoginPage(driver)
                .navigateToLoginPage()
                .login()
                .clickFormsAndListsButton()
                .clickFormsPageButton()
                .clickCreateFormButton()
                .typeFormName(formName)
                .clickShortTextField()
                .typeShortTextFieldNameAndDescription()
                .typeDefaultValueInShortTextField(defaultShortTextValue)
                .clickSaveFormButton()
                .clickPreviewFormButton();

        driver.verifyThat().element(new FormsPage(driver).getShortTextFieldInputInFormReview(defaultShortTextValue)).isVisible();

        new FormsPage(driver)
                .clickClosePreviewFormButton()
                .clickCloseFormButton();

        driver.verifyThat().element(new FormsPage(driver).getFormNameLocator(formName)).isVisible();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}