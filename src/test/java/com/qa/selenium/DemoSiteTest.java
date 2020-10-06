package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.pages.demosite.DemoSite;

public class DemoSiteTest {

    private static RemoteWebDriver driver;
    private static Logger LOGGER = Logger.getGlobal();
    private static WebElement targElement = null;

    @BeforeClass
    public static void initialise(){
        LOGGER.setLevel(Level.ALL);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/webdrivers/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

        // timeouts
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Before
    public void setup() {}

    @Test
    public void createUser(){
        LOGGER.warning("Connecting to The Demo Site....");
        DemoSite webpage = PageFactory.initElements(driver, DemoSite.class);
        
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(DemoSite.URL);
        	
        // STAGE 2 - create a user.
        // ========================================
            LOGGER.info("Creating a new user...\n");
                        
        // STAGE 3 - Log in as created user.
        // ========================================
            LOGGER.info("Logging in as created user...\n");
            
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            String result, expected;
            expected = "**Successful Login**";
            result = targElement.getText();
            
            assertEquals(expected, result);
    }


    @AfterClass
    public static void tearDown() {
        LOGGER.warning("Closing webdriver instance!");

        driver.close();

        LOGGER.info("!!! Webdriver closed successfully !!!");
    }
}