package com.testing.selenium_servlet_register;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {

    @Test
    public void registerTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/selenium-servlet-register/register.html");

        driver.findElement(By.id("username")).sendKeys("ramu");
        driver.findElement(By.className("password")).sendKeys("123");
        driver.findElement(By.id("email")).sendKeys("ramu@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("9999999999");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
