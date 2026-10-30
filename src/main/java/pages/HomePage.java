package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final By USER_MENU_BUTTON = By.xpath("//*[@data-testid='cs-user-menu-button']");
    private static final By USER_ROLE_CITIZEN = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='CITIZEN']");
    private static final By USER_ROLE_CLERK = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='CLERK']");
    private static final By USER_ROLE_SUPERVISOR = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='SUPERVISOR']");
    private static final By USER_ROLE_FIELD_AGENT = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='FIELD_AGENT']");
    private static final By USER_ROLE_ADMINISTRATOR = By.xpath("//*[@data-testid='cs-user-menu']//span[text()='ADMIN']");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickOnUserIcon() {
        driver.findElement(USER_MENU_BUTTON).click();
        return this;
    }

    public String getTextCitizen(){
      return driver.findElement(USER_ROLE_CITIZEN).getText();

    }

    public String getTextClerk(){
        return driver.findElement( USER_ROLE_CLERK).getText();

    }

    public String getTextSupervisor(){
        return driver.findElement(USER_ROLE_SUPERVISOR).getText();

    }

    public String getTextFieldAgent(){
        return driver.findElement(USER_ROLE_FIELD_AGENT).getText();

    }

    public String getTextAdministrator(){
        return driver.findElement(USER_ROLE_ADMINISTRATOR).getText();

    }
}
