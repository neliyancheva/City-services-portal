package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    private static final String EXPECTED_TITLE = "City Services Portal";
    private static final String ERROR_MESSAGE_TITLE = "The title is incorrect";
    private static final String EXPECTED_TEXT_LOGIN_BUTTON = "Login";
    private static final String ERROR_MESSAGE_LOGIN_BUTTON = "The text of the button is incorrect";
    private static final String CITIZEN = "CITIZEN";
    private static final String CLERK = "CLERK";
    private static final String SUPERVISOR = "SUPERVISOR";
    private static final String FIELD_AGENT = "FIELD_AGENT";
    private static final String ADMINISTRATOR = "ADMIN";
    private static final String ERROR_MESSAGE_USER_ROLE = "The role is incorrect";

    @Test
    public void verifyLoginPage() {

        LoginPage loginPage = new LoginPage(driver, wait);


        String actualTitle = loginPage.getTitle();

        Assertions.assertEquals
                (EXPECTED_TITLE, actualTitle, ERROR_MESSAGE_TITLE);

        String actualTextLoginButton = loginPage.loginButtonGetText();

        Assertions.assertEquals
                (EXPECTED_TEXT_LOGIN_BUTTON, actualTextLoginButton, ERROR_MESSAGE_LOGIN_BUTTON);
    }

    @Test
    public void checkCitizenRole() {

        String actualUserRole = new LoginPage(driver, wait)
                .loginWithDefaultCredentialsCitizen()
                .clickOnUserIcon()
                .getTextCitizen();

        Assertions.assertEquals(CITIZEN, actualUserRole, ERROR_MESSAGE_USER_ROLE);
    }

    @Test
    public void checkClerkRole() {

        String actualUserRole = new LoginPage(driver, wait)
                .loginWithDefaultCredentialsClerk()
                .clickOnUserIcon()
                .getTextClerk();

        Assertions.assertEquals(CLERK, actualUserRole, ERROR_MESSAGE_USER_ROLE);
    }

    @Test
    public void checkSupervisorRole() {

        String actualUserRole = new LoginPage(driver, wait)
                .loginWithDefaultCredentialsSupervisor()
                .clickOnUserIcon()
                .getTextSupervisor();

        Assertions.assertEquals(SUPERVISOR, actualUserRole, ERROR_MESSAGE_USER_ROLE);
    }

    @Test
    public void checkFieldAgentRole() {

        String actualUserRole = new LoginPage(driver, wait)
                .loginWithDefaultCredentialsFieldAgent()
                .clickOnUserIcon()
                .getTextFieldAgent();

        Assertions.assertEquals(FIELD_AGENT, actualUserRole, ERROR_MESSAGE_USER_ROLE);
    }

    @Test
    public void checkAdministrator() {

        String actualUserRole = new LoginPage(driver, wait)
                .loginWithDefaultCredentialsAdministrator()
                .clickOnUserIcon()
                .getTextAdministrator();

        Assertions.assertEquals(ADMINISTRATOR, actualUserRole, ERROR_MESSAGE_USER_ROLE);

    }
}
