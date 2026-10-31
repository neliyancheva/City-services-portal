package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmitNewServiceRequestPage {

    private static final By STREET_ADDRESS_FIELD = By.xpath("//*[@data-testid='cs-new-request-street-address']//input[@aria-invalid='false']");
    private static final By CITY_FIELD = By.xpath("");
    private static final By POSTAL_CODE_FIELD = By.xpath("");
    private static final By LOCATION_DESCRIPTION_FIELD = By.xpath("");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SubmitNewServiceRequestPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


}
