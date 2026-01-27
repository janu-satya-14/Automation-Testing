package com.testing.selenium_servlet_register;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {

    @Test
    public void openGoogleTest() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
