package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final By CITIZEN_BUTTON = By.xpath("//button[@data-testid=\"cs-prefill-citizen\"]");
    private static final By CLERK_BUTTON = By.xpath("//*[@data-testid='cs-prefill-clerk']");
    private static final By SUPERVISOR_BUTTON = By.xpath("//button[@data-testid='cs-prefill-supervisor']");
    private static final By FIELD_AGENT_BUTTON = By.xpath("//button[@data-testid='cs-prefill-field-agent']");
    private static final By ADMINISTRATOR_BUTTON = By.xpath("//button[@data-testid='cs-prefill-administrator']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@data-testid='cs-login-submit']");


    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:5173/login");
    }

    public HomePage loginWithDefaultCredentialsCitizen(){
    driver.findElement(CITIZEN_BUTTON).click();
    driver.findElement(LOGIN_BUTTON).click();
    return new HomePage(driver);
    }







}





