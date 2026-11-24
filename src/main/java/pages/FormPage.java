package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class FormPage<TForm> {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected FormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public abstract void fillForm(TForm data);

    public abstract void submitForm();
}
