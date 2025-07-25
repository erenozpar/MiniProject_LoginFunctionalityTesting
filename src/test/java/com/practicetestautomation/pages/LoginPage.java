package com.practicetestautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators on the Login Page
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");
    private By header = By.className("post-header");
    private By logoutButton = By.xpath("//a[.='Log out']");
    private By errorMessage = By.xpath("//div[@class='show']");

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);

    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);

    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }


    public String getSuccessfulMessage() {
        return driver.findElement(header).getText();

    }

    public boolean isErrorMessageDisplayed() {


        return driver.findElement(errorMessage).isDisplayed();

    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();

    }

    public boolean islogoutDisplayed() {

        return driver.findElement(logoutButton).isDisplayed();
    }
    public void scrollToErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", error);
    }
}
