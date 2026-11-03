package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CitizenRequestsPage;
import pages.NewRequestPage;

public class Header {

    private static final By NEW_REQUEST_BUTTON = By.xpath("//*[@data-testid='cs-app-header']//*[@data-testid='cs-nav-new-request']");
    private static final By MY_REQUESTS_BUTTON = By.xpath("//*[@data-testid='cs-app-header']//*[@data-testid='cs-nav-my-requests']");

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public Header (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public NewRequestPage clickOnNewRequestButton(){
        driver.findElement(NEW_REQUEST_BUTTON).click();
        return new NewRequestPage(driver, wait);
    }

    public CitizenRequestsPage clickOnMyRequestsButton(){
    driver.findElement(MY_REQUESTS_BUTTON).click();
    return new CitizenRequestsPage(driver, wait);
    }

}
