package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class FormsPage {

    private final By createFormButton = By.xpath("//button[@data-testid='Setup_Forms_CreateNewForm']");
    private final By formNameInput = By.xpath("//input[@data-id='Setup_Forms_FormName']");

    private final By shortTextField = By.xpath("//div[@data-testid='ticket_type_form_field_Short Text']");
    private final By shortTextFieldNameInput = By.xpath("//textarea[@data-id='Setup_Forms_shorttext_Name']");
    private final By shortTextFieldDescriptionInput = By.xpath("//textarea[@data-id='Setup_Forms_shorttext_Description']");
    private final By shortTextFieldDefaultInput = By.xpath("//input[@data-id='Setup_Forms_ShortText_DefaultValue']");

    private final By previewFormButton = By.xpath("//button[@data-id='setup_forms_preview']");
    private final By closePreviewFormButton = By.xpath("//button[@data-id='Forms_FormPreview_Close']");
    private final By saveFormButton = By.xpath("//button[@data-id='setup_forms_save']");
    private final By closeFormButton = By.xpath("//button[@data-testid='setup_forms_close_button']");
    private final By successMessage = By.xpath("//p[contains(.,'This form has been successfully created.')]");

    private final SHAFT.GUI.WebDriver driver;

    public FormsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the create form button to start creating a new form.
     *
     * @return FormsPage instance for method chaining
     */
    public FormsPage clickCreateFormButton() {
        driver.element().click(createFormButton);
        return this;
    }

    /**
     * Types the form name into the form name input field.
     *
     * @param formName the name to be entered for the form
     * @return FormsPage instance for method chaining
     */
    public FormsPage typeFormName(String formName) {
        driver.element().type(formNameInput, formName);
        return this;
    }

    /**
     * Clicks on the short text field option to add it to the form.
     *
     * @return FormsPage instance for method chaining
     */
    public FormsPage clickShortTextField() {
        driver.element().click(shortTextField);
        return this;
    }

    /**
     * Types the name and description for the short text field.
     *
     * @param fieldName the name of the short text field
     * @param fieldDescription the description of the short text field
     * @return FormsPage instance for method chaining
     */
    public FormsPage typeShortTextFieldNameAndDescription(String fieldName, String fieldDescription) {
        driver.element().type(shortTextFieldNameInput, fieldName);
        driver.element().type(shortTextFieldDescriptionInput, fieldDescription);
        return this;
    }

    /**
     * Types the default value for the short text field.
     *
     * @param defaultShortFieldValue the default value to be set for the short text field
     * @return FormsPage instance for method chaining
     */
    public FormsPage typeDefaultValueInShortTextField(String defaultShortFieldValue) {
        driver.element().type(shortTextFieldDefaultInput, defaultShortFieldValue);
        return this;
    }

    /**
     * Clicks the close button to close the form preview dialog.
     *
     * @return FormsPage instance for method chaining
     */
    public FormsPage clickClosePreviewFormButton() {
        driver.element().click(closePreviewFormButton);
        return this;
    }

    /**
     * Clicks the preview form button to preview the created form.
     */
    public void clickPreviewFormButton() {
        driver.element().click(previewFormButton);
    }

    /**
     * Clicks the save form button and verifies the success message is displayed.
     *
     * @return FormsPage instance for method chaining
     */
    public FormsPage clickSaveFormButton() {
        driver.element().click(saveFormButton);
        driver.element().assertThat(successMessage).isVisible();
        return this;
    }

    /**
     * Clicks the close button to close the form creation dialog.
     */
    public void clickCloseFormButton() {
        driver.element().click(closeFormButton);
    }

    /**
     * Gets the locator for a form name in the forms list.
     *
     * @param formName the name of the form to locate
     * @return By locator for the specified form name
     */
    public By getFormNameLocator(String formName) {
        return By.xpath("//div[@role='gridcell']//span[contains(.,'" + formName + "')]");
    }

    /**
     * Gets the locator for the short text field input in the form preview.
     *
     * @param defaultText the default text value to match in the input field
     * @return By locator for the short text field input with the specified default value
     */
    public By getShortTextFieldInputInFormReview(String defaultText) {
        return By.xpath("//input[@data-testid='ticket_form_field_Test_Short_Text_Field_Name'][@value='" + defaultText + "']");
    }
}
