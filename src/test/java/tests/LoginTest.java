package tests;

import base.BaseTest;
import components.Header;
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
        Header header = new LoginPage(driver, wait)
                .loginWithEmailAndPassword(email, password)
                .clickOnUserIcon();

        String actualUserRole = header
                .getCurrentUserRole();

        Assertions.assertEquals(expectedRole, actualUserRole, ERROR_MESSAGE_USER_ROLE);

        header.clickOnLogoutButton();
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

    @Test
    public void login_maskedPasswordField() {

        String passwordFieldType = new LoginPage(driver, wait)
                .getPasswordFieldType();

        Assertions.assertEquals("password", passwordFieldType, "The password is not masked");
    }

    @Test
    public void unsuccessfulLogin_emailRemainsFilledIn() {
        boolean isEmailPopulated = new LoginPage(driver, wait)
                .loginWithIncorrectEmailAndPassword("john@example.com", "password")
                .isEmailFieldFilledIn();

        Assertions.assertTrue(isEmailPopulated, "The email field is empty");
    }
}