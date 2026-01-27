package com.testing.selenium_servlet_register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void userLoginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/selenium-servlet-register/login.html");

        driver.findElement(By.id("uname")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("123");
        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);

        Assertions.assertEquals("Dashboard", driver.getTitle());

        driver.quit();
    }
}
