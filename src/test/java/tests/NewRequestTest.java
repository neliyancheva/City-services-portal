package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CitizenRequestsPage;
import pages.LoginPage;
import pages.NewRequestPage;

public class NewRequestTest extends BaseTest {

    private static final String INCIDENT_DESCRIPTION = "Traffic light malfunction on Slivnitsa boulevard, potentially causing traffic disruptions and safety risks for road users";
    private static final String STREET_ADDRESS_TEXT = "Slivnitsa 13";
    private static final String CITY_TEXT = "Varna";
    private static final String POSTAL_CODE_TEXT = "9000";
    private static final String LOCATION_DESCRIPTION_TEXT = "Traffic light above the road near Varna mall";
    private static final String EMAIL_TEXT = "nelly.yanch@gmail.com";
    private static final String PHONE_TEXT = "0885796059";
    private static final String EXPECTED_PRIORITY = "High";
    private static final String ERROR_MESSAGE_TITLE = "The title is not found";
    private static final String ERROR_MESSAGE_PRIORITY = "The priority is incorrect";
    private static final String EXPECTED_STATUS = "Submitted";
    private static final String ERROR_MESSAGE_STATUS = "The status is incorrect";

    @Test
    public void createNewSignalWithHighPriority() {

        String title = "The traffic light on Slivnitsa boulevard is not working" + System.currentTimeMillis();

        new LoginPage(driver, wait)
                .loginWithCitizenRole()
                .clickOnNewRequestButton()
                .fillInBasicInformation(title, INCIDENT_DESCRIPTION)
                .fillInLocationDetails(STREET_ADDRESS_TEXT, CITY_TEXT, POSTAL_CODE_TEXT, LOCATION_DESCRIPTION_TEXT)
                .fillInContactInformation(EMAIL_TEXT, PHONE_TEXT)
                .fillInAdditionalDetails()
                .reviewAndSubmit();

        CitizenRequestsPage citizenRequestsPage = new CitizenRequestsPage(driver, wait)
                .clickOnMyRequestsButton();

        String actualTitle = citizenRequestsPage.getTitle();

        String actualPriority = citizenRequestsPage
                .getPriority();

        String actualStatus = citizenRequestsPage
                .getStatus();

        Assertions.assertAll(
                () -> Assertions.assertEquals(title, actualTitle, ERROR_MESSAGE_TITLE),
                () -> Assertions.assertEquals(EXPECTED_PRIORITY, actualPriority, ERROR_MESSAGE_PRIORITY),
                () -> Assertions.assertEquals(EXPECTED_STATUS, actualStatus, ERROR_MESSAGE_STATUS)
        );
    }

}
