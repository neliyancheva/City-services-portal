package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class NewRequestTest extends BaseTest {

    @Test
    public void createNewSignalWithHighPriority(){

        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.loginWithDefaultCredentialsCitizen()
                .clickOnNewRequestButton()
                .fillInTitle()
                .fillInDescription()
                .clickOnHighPriorityButton()
                .clickOnNextButton();
    }
}
