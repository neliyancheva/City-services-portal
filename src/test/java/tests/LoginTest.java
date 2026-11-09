package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private static final String EXPECTED_TITLE = "City Services Portal";
    private static final String ERROR_MESSAGE_TITLE = "The title is incorrect";
    private static final String EXPECTED_TEXT_LOGIN_BUTTON = "Login";
    private static final String ERROR_MESSAGE_LOGIN_BUTTON = "The text of the button is incorrect";
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

    @ParameterizedTest
    @CsvSource({"john@example.com, password123, CITIZEN",
            "mary.clerk@city.gov, password123, CLERK",
            "supervisor@city.gov, password123, SUPERVISOR",
            "field.agent@city.gov, password123, FIELD_AGENT",
            "admin@city.gov, password123, ADMIN"})
    public void loginWithEmailAndPassword_getExpectedRole(String email, String password, String expectedRole) {
        String actualUserRole = new LoginPage(driver, wait)
                .loginWithEmailAndPassword(email, password)
                .clickOnUserIcon()
                .getCurrentUserRole();

        Assertions.assertEquals(expectedRole, actualUserRole, ERROR_MESSAGE_USER_ROLE);
    }

    @ParameterizedTest
    @CsvSource({"john@example.com, password12",
            "unknown@city.gov, password123"})
//  Empty email scenario cannot be tested due to pop-up error message which does not exist in DOM
    public void loginWithIncorrectCredentials_errorMessageIsDisplayed(String email, String password) {
        boolean isErrorMessageDisplayed = new LoginPage(driver, wait)
                .loginWithIncorrectEmailAndPassword(email, password)
                .isErrorMessageDisplayed();

        Assertions.assertTrue(isErrorMessageDisplayed, "Error message is not displayed");
    }
}