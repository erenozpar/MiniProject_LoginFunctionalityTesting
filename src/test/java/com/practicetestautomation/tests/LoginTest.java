package com.practicetestautomation.tests;

import com.practicetestautomation.pages.LoginPage;
import com.practicetestautomation.utilities.Driver;

import com.practicetestautomation.utilities.ExelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends Driver {


    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        String path = "src/main/resources/LoginTestData.xlsx";
        return ExelUtils.getTestData(path, "LoginTestData");
    }


    @Test(dataProvider = "loginData")
    public void LoginTests(String username, String password, String expectedResult) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        boolean emd;
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

        Thread.sleep(100);



        switch (expectedResult) {


            case "success":
                assertEquals(loginPage.getSuccessfulMessage(), "Logged In Successfully");
                boolean logoutButtonDisplayed = loginPage.islogoutDisplayed();
                assertTrue(logoutButtonDisplayed, "Logout Button should be displayed after login");
                break;

            case "invalid-username":
                emd = loginPage.isErrorMessageDisplayed();
                loginPage.scrollToErrorMessage();
                Assert.assertTrue(emd);
                Assert.assertEquals("Your username is invalid!", loginPage.getErrorMessage());
                break;

            case "invalid-password":
                emd = loginPage.isErrorMessageDisplayed();
                loginPage.scrollToErrorMessage();
                Assert.assertTrue(emd);
                Assert.assertEquals("Your password is invalid!", loginPage.getErrorMessage());
                break;
            case "empty-username":
                emd = loginPage.isErrorMessageDisplayed();
                loginPage.scrollToErrorMessage();
                Assert.assertTrue(emd);
                Assert.assertEquals("Your username is invalid!", loginPage.getErrorMessage());
                break;

            case "empty-password":
                emd = loginPage.isErrorMessageDisplayed();
                loginPage.scrollToErrorMessage();
                Assert.assertTrue(emd);
                Assert.assertEquals("Your password is invalid!", loginPage.getErrorMessage());
                break;
        }
    }
}
/*
Add PageFactory for better Page Object design.

Integrate with Jenkins for CI/CD.

Add negative test for locked users or expired passwords.

Add logging using Log4j or SLF4J.
*/

/*
    @Test
    @Parameters({"invalidUsername", "password"})
    public void NegativeUsernameTest(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
        loginPage.scrollToErrorMessage();
        Thread.sleep(100);
        assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals("Your username is invalid!", loginPage.getErrorMessage());


    }

    @Test
    @Parameters({"username", "invalidPassword"})
    public void NegativePasswordTest(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
        loginPage.scrollToErrorMessage();
        Thread.sleep(100);
        assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals("Your password is invalid!", loginPage.getErrorMessage());

    }

    @Test
    @Parameters({"emptyUsername", "password"})
    public void EmptyUsernameTest(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
        loginPage.scrollToErrorMessage();
        Thread.sleep(100);
        assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals("Your username is invalid!", loginPage.getErrorMessage());
    }

    @Test
    @Parameters({"username", "emptyPassword"})
    public void EmptyPasswordTest(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
        loginPage.scrollToErrorMessage();
        Thread.sleep(100);
        assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals("Your password is invalid!", loginPage.getErrorMessage());

    }
*/
