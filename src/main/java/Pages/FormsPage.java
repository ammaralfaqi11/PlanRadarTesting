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
    private final By shortTextFieldMandatoryInput = By.xpath("//span[contains(.,'Mandatory')]/parent::label");



    private final By checkboxField = By.xpath("//div[@data-testid='ticket_type_form_field_Checkbox']");
    private final By checkboxFieldNameInput = By.xpath("//textarea[@data-id='Setup_Forms_checkbox_Name']");

    private final By listField = By.xpath("//div[@data-testid='ticket_type_form_field_List']");
    private final By priorityField = By.xpath("//div[@data-testid='ticket_type_form_field_Priority']");
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

    public FormsPage makeShortTextFieldMandatory(){
        driver.element().click(shortTextFieldMandatoryInput);
        return this;
    }

    public FormsPage clickCheckboxField() {
        driver.element().click(checkboxField);
        return this;
    }
    
    public FormsPage clickListField() {
        driver.element().click(listField);
        return this;
    }

    public FormsPage clickPriorityField() {
        driver.element().click(priorityField);
        return this;
    }

    public FormsPage clickSaveFormButton() {
        driver.element().click(saveFormButton);
        driver.element().assertThat(successMessage).isVisible();
        return this;
    }

    public void clickCloseFormButton(){
        driver.element().click(closeFormButton);
    }

    public By getFormNameLocator(String formName){
        return By.xpath("//div[@role='gridcell']//span[contains(.,'" + formName + "')]");
    }
}
