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

    public FormsPage clickCreateFormButton() {
        driver.element().click(createFormButton);
        return this;
    }

    public FormsPage typeFormName(String formName) {
        driver.element().type(formNameInput, formName);
        return this;
    }

    public FormsPage clickShortTextField() {
        driver.element().click(shortTextField);
        return this;
    }

    public FormsPage typeShortTextFieldNameAndDescription() {
        driver.element().type(shortTextFieldNameInput, "Test Short Text Field Name");
        driver.element().type(shortTextFieldDescriptionInput, "Test Short Text Field Description");
        return this;
    }

    public FormsPage typeDefaultValueInShortTextField(String defaultShortFieldValue) {
        driver.element().type(shortTextFieldDefaultInput, defaultShortFieldValue);
        return this;
    }

    public FormsPage clickClosePreviewFormButton() {
        driver.element().click(closePreviewFormButton);
        return this;
    }

    public void clickPreviewFormButton() {
        driver.element().click(previewFormButton);
    }

    public FormsPage clickSaveFormButton() {
        driver.element().click(saveFormButton);
        driver.element().assertThat(successMessage).isVisible();
        return this;
    }

    public void clickCloseFormButton() {
        driver.element().click(closeFormButton);
    }

    public By getFormNameLocator(String formName) {
        return By.xpath("//div[@role='gridcell']//span[contains(.,'" + formName + "')]");
    }

    public By getShortTextFieldInputInFormReview(String defaultText) {
        return By.xpath("//input[@data-testid='ticket_form_field_Test_Short_Text_Field_Name'][@value='" + defaultText + "']");
    }
}
