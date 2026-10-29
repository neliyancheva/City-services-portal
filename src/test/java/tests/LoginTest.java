package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    private static final String EXPECTED_TITLE = "City Services Portal";
    private static final String ERROR_MESSAGE_TITLE = "The title is incorrect";
    private static final String EXPECTED_TEXT_LOGIN_BUTTON = "Login";
    private static final String ERROR_MESSAGE_LOGIN_BUTTON = "The text of the button is incorrect";

    @Test
    public void verifyLoginPage(){

        LoginPage loginPage = new LoginPage(driver);
        


    }

}
