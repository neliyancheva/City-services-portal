package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CitizenRequestsPage;
import pages.LoginPage;
import pages.NewRequestPage;

public class Header {

    private static final By NEW_REQUEST_BUTTON = By.xpath("//*[@data-testid='cs-app-header']//*[@data-testid='cs-nav-new-request']");
    private static final By MY_REQUESTS_BUTTON = By.xpath("//*[@data-testid='cs-app-header']//*[@data-testid='cs-nav-my-requests']");
    private static final By USER_MENU_BUTTON = By.xpath("//*[@data-testid='cs-user-menu-button']");
    private static final By USER_ROLE_CITIZEN = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='CITIZEN']");
    private static final By USER_ROLE_CLERK = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='CLERK']");
    private static final By USER_ROLE_SUPERVISOR = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='SUPERVISOR']");
    private static final By USER_ROLE_FIELD_AGENT = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='FIELD_AGENT']");
    private static final By USER_ROLE_ADMINISTRATOR = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='ADMIN']");
    private static final By USER_ROLE = By.xpath("//*[@role='menuitem']//div/div/span");
    private static final By LOGOUT_BUTTON = By.xpath("//*[@data-testid='cs-user-menu-logout']");

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

    public Header clickOnUserIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(USER_MENU_BUTTON)).click();
        return this;
    }

    public String getCurrentUserRole(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(USER_ROLE)).getText();
    }

    public LoginPage clickOnLogoutButton(){
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver, wait);
    }

}
