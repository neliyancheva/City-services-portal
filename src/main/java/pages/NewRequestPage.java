package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRequestPage {

    private static final By REQUEST_TITLE_FIELD = By.xpath("//*[@data-testid='cs-new-request-date']//input[@aria-invalid='false']");
    private static final By DESCRIPTION_FIELD = By.xpath("//*[@data-testid='cs-new-request-description']//*[@aria-invalid='false']");
    private static final By HIGH_PRIORITY_BUTTON = By.xpath("//*[@data-testid='cs-new-request-priority']//label[.//span[text()='High']]");
    private static final By NEXT_BUTTON = By.xpath("//button[@data-testid='cs-new-request-wizard-next']");
    private static final String THE_TRAFFIC_LIGHT_IS_NOT_WORKING = "The traffic light on Slivnitsa boulevard is not working";
    private static final String INCIDENT_DESCRIPTION = "Traffic light malfunction on Slivnitsa boulevard, potentially causing traffic disruptions and safety risks for road users";


    private final WebDriver driver;
    private final WebDriverWait wait;

    public NewRequestPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public NewRequestPage fillInTitle() {
        driver.findElement(REQUEST_TITLE_FIELD).sendKeys(THE_TRAFFIC_LIGHT_IS_NOT_WORKING);
        return new NewRequestPage(driver, wait);
    }

    public NewRequestPage fillInDescription() {
        driver.findElement(DESCRIPTION_FIELD).sendKeys(INCIDENT_DESCRIPTION);
        return new NewRequestPage(driver, wait);
    }

    public NewRequestPage clickOnHighPriorityButton(){
        driver.findElement(HIGH_PRIORITY_BUTTON).click();
        return new NewRequestPage(driver, wait);
    }

    public SubmitNewServiceRequestPage clickOnNextButton(){
        driver.findElement(NEXT_BUTTON).click();
        return new SubmitNewServiceRequestPage(driver, wait);
    }


}

