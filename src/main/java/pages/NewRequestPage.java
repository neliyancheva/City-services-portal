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

    public NewRequestPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NewRequestPage fillInBasicInformation(String title, String description) {
        input(REQUEST_TITLE_FIELD, title);
        input(DESCRIPTION_FIELD, description);
        click(CATEGORY_BUTTON);
        click(ROADS_AND_INFRASTRUCTURE_DROPDOWN);
        wait.until(ExpectedConditions.elementToBeClickable(HIGH_PRIORITY_BUTTON)).click();
        click(HIGH_PRIORITY_BUTTON);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage fillInLocationDetails(String streetAddress, String city, String postalCode, String locationDescription) {
        input(STREET_ADDRESS_FIELD, streetAddress);
        input(CITY_FIELD, city);
        input(POSTAL_CODE_FIELD, postalCode);
        input(LOCATION_DESCRIPTION_FIELD, locationDescription);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage fillInContactInformation(String email, String phone) {
        input(EMAIL_FIELD, email);
        input(PHONE_FIELD, phone);
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


