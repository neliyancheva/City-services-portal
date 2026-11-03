package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public HomePage loginWithDefaultCredentialsCitizen() {
        driver.findElement(CITIZEN_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver, wait);
    }

    public HomePage loginWithDefaultCredentialsClerk() {
        driver.findElement(CLERK_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver, wait);
    }

    public HomePage loginWithDefaultCredentialsSupervisor() {
        driver.findElement(SUPERVISOR_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver, wait);
    }

    public HomePage loginWithDefaultCredentialsFieldAgent() {
        driver.findElement(FIELD_AGENT_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver, wait);
    }

    public HomePage loginWithDefaultCredentialsAdministrator() {
        driver.findElement(ADMINISTRATOR_BUTTON).click();
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver, wait);
    }

    public HomePage loginWithCitizenRole(){
        driver.findElement(EMAIL_FIELD).sendKeys("john@example.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("password123");
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver, wait);
    }
}







