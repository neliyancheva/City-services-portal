package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import components.Header;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRequestPage extends Header {

    private static final By REQUEST_TITLE_FIELD = By.xpath("//input[@name='title']");
    private static final By DESCRIPTION_FIELD = By.xpath("//*[@data-testid='cs-new-request-description']//*[@aria-invalid='false']");
    private static final By HIGH_PRIORITY_BUTTON = By.xpath("//*[@data-testid='cs-new-request-priority']//label[.//span[text()='High']]");
    private static final By NEXT_BUTTON = By.xpath("//button[@data-testid='cs-new-request-wizard-next']");
    private static final By STREET_ADDRESS_FIELD = By.xpath("//*[@data-testid='cs-new-request-street-address']//input[@aria-invalid='false']");
    private static final By CITY_FIELD = By.xpath("//input[@name='city']");
    private static final By POSTAL_CODE_FIELD = By.xpath("//input[@name='postalCode']");
    private static final By LOCATION_DESCRIPTION_FIELD = By.xpath("//input[@name='locationText']");
    private static final By CATEGORY_BUTTON = By.xpath("//*[@id='mui-component-select-category']");
    private static final By ROADS_AND_INFRASTRUCTURE_DROPDOWN = By.xpath("//*[@data-value='roads-and-infrastructure']");
    private static final By EMAIL_FIELD = By.xpath("//input[@name='email']");
    private static final By PHONE_FIELD = By.xpath("//input[@name='phone']");
    private static final By CHECKBOX_FIELD = By.xpath("//*[text()='I agree to the terms and conditions']");
    private static final By SUBMIT_REQUEST_BUTTON = By.xpath("//button[@data-testid='cs-new-request-wizard-submit']");


    private static final String STREET_ADDRESS_TEXT = "Slivnitsa 13";
    private static final String CITY_TEXT = "Varna";
    private static final String POSTAL_CODE_TEXT = "9000";
    private static final String LOCATION_DESCRIPTION_TEXT = "Traffic light above the road near Varna mall";
    private static final String EMAIL_TEXT = "nelly.yanch@gmail.com";
    private static final String PHONE_TEXT = "0885796059";

    public NewRequestPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NewRequestPage fillInBasicInformation(String title, String description) {
        input(REQUEST_TITLE_FIELD, title);
        input(DESCRIPTION_FIELD, description);
        click(CATEGORY_BUTTON);
        click(ROADS_AND_INFRASTRUCTURE_DROPDOWN);
        click(HIGH_PRIORITY_BUTTON);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage fillInLocationDetails() {
        input(STREET_ADDRESS_FIELD, STREET_ADDRESS_TEXT);
        input(CITY_FIELD, CITY_TEXT);
        input(POSTAL_CODE_FIELD, POSTAL_CODE_TEXT);
        input(LOCATION_DESCRIPTION_FIELD, LOCATION_DESCRIPTION_TEXT);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage fillInContactInformation() {
        input(EMAIL_FIELD, EMAIL_TEXT);
        input(PHONE_FIELD, PHONE_TEXT);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage fillInAdditionalDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_FIELD)).click();
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage reviewAndSubmit() {
        click(SUBMIT_REQUEST_BUTTON);
        return this;
    }

    private void input(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
}

