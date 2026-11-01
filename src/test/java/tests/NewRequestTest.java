package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class NewRequestTest extends BaseTest {

    private static final String REQUEST_TITLE = "The traffic light on Slivnitsa boulevard is not working";
    private static final String INCIDENT_DESCRIPTION = "Traffic light malfunction on Slivnitsa boulevard, potentially causing traffic disruptions and safety risks for road users";

    @Test
    public void createNewSignalWithHighPriority(){

        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.loginWithDefaultCredentialsCitizen()
                .clickOnNewRequestButton()
                .fillInBasicInformation(REQUEST_TITLE,INCIDENT_DESCRIPTION)
                .fillInLocationDetails()
                .fillInContactInformation()
                .fillInAdditionalDetails()
                .reviewAndSubmit();

    }
}
