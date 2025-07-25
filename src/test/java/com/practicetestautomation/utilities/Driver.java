package com.practicetestautomation.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Driver {
    protected static WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.get("https://practicetestautomation.com/practice-test-login/");
        } else if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
            driver.get("https://practicetestautomation.com/practice-test-login/");
        } else {
            throw new Exception("invalid browser");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }



    }

    public static WebDriver getDriver(){
         return driver;
    }
}
