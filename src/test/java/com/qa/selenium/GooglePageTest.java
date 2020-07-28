package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GooglePageTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/webdrivers/chromedriver_win32/chromedriver.exe");

        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);

        driver = new ChromeDriver(opts);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://google.com");

        assertEquals("Google", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}