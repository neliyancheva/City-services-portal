package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://www.selenium.dev/documentation/");
        chromeDriver.findElement(By.xpath("//*[@id='m-documentationgrid']")).click();
        chromeDriver.quit();


    }
}