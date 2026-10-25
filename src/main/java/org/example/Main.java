package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features-PasswordLeakDetection");
        WebDriver chromeDriver = new ChromeDriver(options);

        chromeDriver.navigate().to("http://localhost:5173/login");
        String actualTitle = chromeDriver.getTitle();
        String expectedTitle = "City Services Portal";

        Assertions.assertEquals(expectedTitle, actualTitle, "The site is incorrect");

        WebElement loginButton = chromeDriver.findElement(By.xpath("//button[@type=\"submit\"]"));

        String actualTextButton = loginButton.getText();
        String expectedTextButton = "Login";

        Assertions.assertEquals(expectedTextButton, actualTextButton, "The text button is incorrect");

        WebElement citizenButton = chromeDriver.findElement
                (By.xpath("//button[@data-testid=\"cs-prefill-citizen\"]"));
        citizenButton.click();
        loginButton.click();

        chromeDriver.quit();
    }
}