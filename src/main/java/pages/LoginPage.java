package pages;

import components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private static final By CITIZEN_BUTTON = By.xpath("//button[@data-testid=\"cs-prefill-citizen\"]");
    private static final By CLERK_BUTTON = By.xpath("//*[@data-testid='cs-prefill-clerk']");
    private static final By SUPERVISOR_BUTTON = By.xpath("//button[@data-testid='cs-prefill-supervisor']");
    private static final By FIELD_AGENT_BUTTON = By.xpath("//button[@data-testid='cs-prefill-field-agent']");
    private static final By ADMINISTRATOR_BUTTON = By.xpath("//button[@data-testid='cs-prefill-administrator']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@data-testid='cs-login-submit']");
    private static final By EMAIL_FIELD = By.xpath("//input[@type='email']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private static final By ERROR_MESSAGE_LOGIN = By.xpath("//*[@data-testid='cs-login-error']");


    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        driver.get("http://localhost:5173/login");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String loginButtonGetText() {
        return driver.findElement(LOGIN_BUTTON).getText();
    }

    public Header loginWithDefaultCredentialsCitizen() {
        driver.findElement(CITIZEN_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public Header loginWithDefaultCredentialsClerk() {
        driver.findElement(CLERK_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public Header loginWithDefaultCredentialsSupervisor() {
        driver.findElement(SUPERVISOR_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public Header loginWithDefaultCredentialsFieldAgent() {
        driver.findElement(FIELD_AGENT_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public Header loginWithDefaultCredentialsAdministrator() {
        driver.findElement(EMAIL_FIELD).sendKeys("john@example.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("password123");
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public Header loginWithCitizenRole(){
        driver.findElement(EMAIL_FIELD).sendKeys("john@example.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("password123");
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public Header loginWithEmailAndPassword(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new Header(driver, wait);
    }

    public LoginPage loginWithIncorrectEmailAndPassword(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public boolean isErrorMessageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_LOGIN)).isDisplayed();
    }

}







