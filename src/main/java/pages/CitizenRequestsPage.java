package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import components.Header;

public class CitizenRequestsPage extends Header {

    private static final By TITLE = By.xpath("//div[@data-rowindex='0']//div[@data-field='title']");
    private static final By PRIORITY = By.xpath("//div[@data-rowindex='0']//div[@data-field='priority']");
    private static final By STATUS = By.xpath("//div[@data-rowindex='0']//div[@data-field='status']");


    public CitizenRequestsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getTitle() {
        return wait.ignoring(StaleElementReferenceException.class).until(d -> d.findElement(TITLE)).getText();
    }

    public String getPriority() {
        return wait.ignoring(StaleElementReferenceException.class).until(d -> d.findElement(PRIORITY)).getText();
    }

    public String getStatus() {
        return driver.findElement(STATUS).getText(); //wait.ignoring(StaleElementReferenceException.class).until(d -> d.findElement(STATUS)).getText();

    }
}

