package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String EXPECTED_TITLE = "City Services Portal";
    private static final String ERROR_MESSAGE_TITLE = "The title is incorrect";
    private static final String EXPECTED_TEXT_LOGIN_BUTTON = "Login";
    private static final String ERROR_MESSAGE_LOGIN_BUTTON = "The text of the button is incorrect";
    private static final String EXPECTED_USER_ROLE_CITIZEN = "CITIZEN";
    private static final String ERROR_MESSAGE_USER_ROLE = "The role is incorrect";
    private static final String EXPECTED_USER_ROLE_CLERK = "CLERK";
    private static final String EXPECTED_USER_ROLE_SUPERVISOR = "SUPERVISOR";


    public static void main(String[] args) {

//        final Map<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("credentials_enable_service", false);
//        chromePrefs.put("profile.password_manager_enabled", false);
//        chromePrefs.put("profile.password_manager_leak_detection", false);
//
       final ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);

        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        chromeDriver.navigate().to("http://localhost:5173/login");
        String actualTitle = chromeDriver.getTitle();

        Assertions.assertEquals
                (EXPECTED_TITLE, actualTitle, ERROR_MESSAGE_TITLE);

       WebElement loginButton = chromeDriver.findElement(By.xpath("//*[@data-testid='cs-login-submit']"));

        String actualTextLoginButton = loginButton.getText();

        Assertions.assertEquals
                (EXPECTED_TEXT_LOGIN_BUTTON, actualTextLoginButton, ERROR_MESSAGE_LOGIN_BUTTON);

        WebElement citizenButton = chromeDriver.findElement
                (By.xpath("//button[@data-testid=\"cs-prefill-citizen\"]"));
        citizenButton.click();
        clickOnLoginButton(chromeDriver);
        clickOnUserMenuButton(chromeDriver);

        WebElement userRoleCitizen = chromeDriver.findElement
                (By.xpath("//*[@data-testid='cs-user-menu']//span[text()='CITIZEN']"));

        String actualUserRoleCitizen = userRoleCitizen.getText();

        Assertions.assertEquals
                (EXPECTED_USER_ROLE_CITIZEN, actualUserRoleCitizen, ERROR_MESSAGE_USER_ROLE);

        clickOnLogoutButton(chromeDriver);

        WebElement clerkButton = chromeDriver.findElement
                (By.xpath("//*[@data-testid='cs-prefill-clerk']"));
        clerkButton.click();
        clickOnLoginButton(chromeDriver);
        clickOnUserMenuButton(chromeDriver);

        WebElement userRoleClerk = chromeDriver.findElement
                (By.xpath("//*[@data-testid='cs-user-menu']//span[text()='CLERK']"));

        String actualUserROleClerk = userRoleClerk.getText();

        Assertions.assertEquals
                (EXPECTED_USER_ROLE_CLERK, actualUserROleClerk, ERROR_MESSAGE_USER_ROLE);

        clickOnLogoutButton(chromeDriver);

        WebElement supervisorButton = chromeDriver.findElement
                (By.xpath("//button[@data-testid='cs-prefill-supervisor']"));
        supervisorButton.click();
        clickOnLoginButton(chromeDriver);
        clickOnUserMenuButton(chromeDriver);

        WebElement userRoleSupervisor = chromeDriver.findElement
                (By.xpath("//*[@data-testid='cs-user-menu']//span[text()='SUPERVISOR']"));

        String actualUserRoleSupervisor = userRoleSupervisor.getText();

        Assertions.assertEquals
                (EXPECTED_USER_ROLE_SUPERVISOR, actualUserRoleSupervisor, ERROR_MESSAGE_USER_ROLE);

    chromeDriver.quit();
    }

    private static void clickOnLoginButton(WebDriver driver){
        driver.findElement(By.xpath("//*[@data-testid='cs-login-submit']")).click();
    }

    private static void clickOnUserMenuButton(WebDriver driver){
        driver.findElement(By.xpath("//*[@data-testid='cs-user-menu-button']")).click();
    }

    private static void clickOnLogoutButton(WebDriver driver){
        driver.findElement(By.xpath("//*[@data-testid='cs-user-menu-logout']")).click();
    }

}