package Tests;

import Pages.FormsPage;
import Pages.LoginPage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateDefaultValueAppearanceTest {
    private SHAFT.GUI.WebDriver driver;
    private static final String formName = "Test Form name " + System.currentTimeMillis();
    private static final String defaultShortTextValue = "Test Default Text";
    private static final String shortTextFieldName = "Test Short Text Field Name";
    private static final String shortTextFieldDescription = "Test Short Text Field Description";

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Create a form with a default value for short text field and verify it appears in preview")
    public void createNewFormWithDefaultValue() {
        new LoginPage(driver)
                .navigateToLoginPage()
                .login()
                .clickFormsAndListsButton()
                .clickFormsPageButton()
                .clickCreateFormButton()
                .typeFormName(formName)
                .clickShortTextField()
                .typeShortTextFieldNameAndDescription(shortTextFieldName, shortTextFieldDescription)
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