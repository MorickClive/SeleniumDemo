package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoSite {

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

        // STAGE 1 - navigate to site.
        // ========================================

            // I want to navigate to....
            driver.get("http://thedemosite.co.uk/");

        // STAGE 2 - create a user.
        // ========================================
            LOGGER.info("Creating a new user...\n");

            // I need to navigate to add a user page
            targElement = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
            targElement.click();

            // Enter username and password
            String[] val = {"root", "root"};

            targElement = driver.findElement(By.name("username"));
            targElement.sendKeys(val[0]);

            targElement = driver.findElement(By.name("password"));
            targElement.sendKeys(val[1]);

            // Save user
            driver.findElement(By.name("FormsButton2")).click();

        // STAGE 3 - Log in as created user.
        // ========================================
            LOGGER.info("Logging in as created user...\n");

            // I need to navigate to add a user page
            driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();

            // Enter Credentials
            targElement = driver.findElement(By.name("username"));
            targElement.sendKeys(val[0]);

            targElement = driver.findElement(By.name("password"));
            targElement.sendKeys(val[1]);

            // Login
            targElement = driver.findElement(By.name("FormsButton2"));
            targElement.click();

        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            targElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
            assertEquals("**Successful Login**", targElement.getText());
    }


    @AfterClass
    public static void tearDown() {
        LOGGER.warning("Closing webdriver instance!");

        driver.close();

        LOGGER.info("!!! Webdriver closed successfully !!!");
    }
}